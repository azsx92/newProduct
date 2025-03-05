package com.frankit.product_v1.domain.auth.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum Role {
    ADMIN("MASTER","master"),
    PARTNER("PARTNER","partner"),
    STAY("STAY","stay");

    private String code;
    private String value;

}

