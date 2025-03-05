package com.frankit.product_v1.common.enums.admin;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum PermissionEnum {
    READ("READ","읽기"),
    WRITE("WRITE","쓰기"),
    DELETE("DELETE","삭제");

    private String code;
    private String value;
}
