package com.frankit.product_v1.util;

import com.frankit.product_v1.domain.admin.model.AdminEntity;
import com.frankit.product_v1.domain.auth.model.LoginAccount;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;


import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class JwtTokenUtil {

    // https://generate-random.org/encryption-key-generator
    private static final String SECRET_KEY = "7Iqk7YWM7J207Jik642U64m07ZSE66Gc7KCd7Yq47YKk7IOd7ISx7J6F64uI64uk66mU66GxLg==";

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    public String generateToken(UserDetails userDetails) {
        if( userDetails == null) return null;
        return generateToken(new HashMap<>(), userDetails);
    }

    public LoginAccount getAccount(String token) {
        Claims claims = extractAllClaims(token);
        return LoginAccount.builder()
                .username(claims.get("username", String.class))
                .auth(claims.get("auth", String.class))
                .kind(claims.get("kind", String.class))
                .build();
    }

    public String generateToken(Map<String, Object> extraClaims, UserDetails userDetails) {

        AdminEntity adminEntity = (AdminEntity) userDetails;
        extraClaims.put("username",adminEntity.getUsername());
        extraClaims.put("state", adminEntity.getState());
        extraClaims.put("auth",adminEntity.getAuth());
        extraClaims.put("kind",adminEntity.getKind());

        return Jwts.builder()
                .setClaims(extraClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 6)) // 6시간
                .signWith(getSignInKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername())) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSignInKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private Key getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}