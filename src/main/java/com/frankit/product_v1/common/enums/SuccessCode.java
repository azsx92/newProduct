package com.frankit.product_v1.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum SuccessCode {
    COMMON_SYSTEM_SUCCESS("2000","정상"),
    COMMON_SYSTEM_LOGIN_ID_OK("2001","사용가능한 아이디 입니다.");

    private String code;
    private String value;
}

