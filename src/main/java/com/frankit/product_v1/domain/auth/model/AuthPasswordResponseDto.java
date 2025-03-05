package com.frankit.product_v1.domain.auth.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthPasswordResponseDto {
    private String password;
    private String username;
    private String name;

}
