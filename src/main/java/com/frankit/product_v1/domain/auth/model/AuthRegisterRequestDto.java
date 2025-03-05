package com.frankit.product_v1.domain.auth.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthRegisterRequestDto {

    private String loginId;
    private String password;
    private String auth;
    private String name;
    private String state;

}
