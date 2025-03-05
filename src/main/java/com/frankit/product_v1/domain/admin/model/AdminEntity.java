package com.frankit.product_v1.domain.admin.model;


import com.frankit.product_v1.common.enums.admin.PermissionEnum;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "admin")
public class AdminEntity implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "name")
    private String name;

    @Column(name = "state")
    private String state;
    @Column(name = "auth")
    private String auth;
    @Column(name = "kind")
    private String kind;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        List<GrantedAuthority> roles = new ArrayList<>();
        if (!this.kind.equals("ADMIN_TYPE_USER")) {
            roles = List.of(new SimpleGrantedAuthority(this.getAuth())
                    , new SimpleGrantedAuthority(PermissionEnum.READ.getCode())
                    , new SimpleGrantedAuthority(PermissionEnum.WRITE.getCode())
                    , new SimpleGrantedAuthority(PermissionEnum.DELETE.getCode()));
        } else {
            roles = List.of(new SimpleGrantedAuthority(this.getAuth())
                    , new SimpleGrantedAuthority(PermissionEnum.READ.getCode()));
        }

        return roles;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
