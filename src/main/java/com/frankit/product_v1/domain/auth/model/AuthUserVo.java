package com.frankit.product_v1.domain.auth.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

@Data
public class AuthUserVo implements UserDetails {

    Long adminId;
    String loginId;
    String loginPwd;
    String adminNm;
    String editPassword;
    Long hotelId;
    String regDt;
    Long adminLevel;
    String adminType;

    private Map<String, Object> details = new HashMap<>();

    public String getDetailByString(String key) {
        return getDetail(key) == null ? "" : (String) getDetail(key);
    }

    public Object getDetail(String key) {
        if (details.containsKey(key)) {
            return details.get(key);
        }
        return null;
    }

    public void addDetails(String key, String value) {
        details.put(key, value);
    }

    private List<String> authorityList = new ArrayList<>();
    private List<String> authGroupList = new ArrayList<>();

    @Override
    @JsonIgnore
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> simpleGrantedAuthorities = new ArrayList<>();
        authorityList.forEach(role -> simpleGrantedAuthorities.add(new SimpleGrantedAuthority(role)));
        return simpleGrantedAuthorities;
    }

    public void addAuthority(String role) {
        authorityList.add("ROLE_" + role);
    }

    public boolean hasRole(String role) {
        return authorityList.stream().anyMatch(a -> a.equals("ROLE_" + role));
    }

    public void addAuthGroup(String grpAuthCd) {
        authGroupList.add(grpAuthCd);
    }

    @Override
    @JsonIgnore
    public String getPassword() {
        return loginPwd;
    }

    @Override
    @JsonIgnore
    public String getUsername() {
        return loginId;
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isEnabled() {
        return true;
    }


}
