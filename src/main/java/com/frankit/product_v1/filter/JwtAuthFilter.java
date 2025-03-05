package com.frankit.product_v1.filter;



import com.frankit.product_v1.common.enums.ErrorCode;
import com.frankit.product_v1.util.JwtTokenUtil;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;


import java.io.IOException;

@Slf4j
@Component
@RequiredArgsConstructor
public class JwtAuthFilter extends OncePerRequestFilter {

    private final JwtTokenUtil jwtTokenUtil;
    private final UserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {

        String jwt = getJwtFromRequest(request);

        try {
            if ( jwt != null ) {
                String username = jwtTokenUtil.extractUsername(jwt);
                UserDetails userDetails = userDetailsService.loadUserByUsername(username);
                UsernamePasswordAuthenticationToken authentication =
                        new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }
        catch (SecurityException e) {
//            log.info("Invalid JWT signature");
//            throw new InvalidRequestException(LoginErrorCode.AUTH_INVALID_SIGNATURE);
            request.setAttribute("errorCode", ErrorCode.AUTH_INVALID_SIGNATURE.getErrorCode());
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        }
        catch (MalformedJwtException e) {
            log.info("유효하지 않은 구성의 JWT 토큰");
//            throw new InvalidRequestException(LoginErrorCode.AUTH_INVALID_TOKEN);
            request.setAttribute("errorCode", ErrorCode.AUTH_INVALID_TOKEN.getErrorCode());
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        }
        catch (ExpiredJwtException e) {
            log.info("만료된 JWT 토큰");
//            throw new InvalidRequestException(LoginErrorCode.AUTH_TOKEN_EXPIRATION);
            request.setAttribute("errorCode", ErrorCode.AUTH_TOKEN_EXPIRATION.getErrorCode());
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

        }
        catch (UnsupportedJwtException e) {
            log.info("지원되지 않는 JWT 형식");
//            throw new InvalidRequestException(LoginErrorCode.AUTH_TOKEN_UNSUPPORTED);
            request.setAttribute("errorCode", ErrorCode.AUTH_TOKEN_UNSUPPORTED.getErrorCode());
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        }
        catch (IllegalArgumentException e) {
            log.info("JWT token compact of handler are invalid");
//            throw new InvalidRequestException(LoginErrorCode.AUTH_TOKEN_COMPACT);
            request.setAttribute("errorCode", ErrorCode.AUTH_TOKEN_COMPACT.getErrorCode());
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        }
        catch (Exception e) {
            log.info("잘못된 JWT 값 오류");
//            throw new InvalidRequestException(LoginErrorCode.AUTH_TOKEN_UNSUPPORTED);
            request.setAttribute("errorCode", ErrorCode.AUTH_TOKEN_UNSUPPORTED.getErrorCode());
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        }
        chain.doFilter(request, response);
    }

    private String getJwtFromRequest(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return null;
    }


}
