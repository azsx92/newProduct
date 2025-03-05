package com.frankit.product_v1.common.enums.admin;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum AdminTypeEnum {

    // 로그인 할때 재정의가 필요할것 같습니다!!!!

    ADMIN_TYPE_MASTER("ADMIN_TYPE_MASTER", "마스터 관리자"),
    ADMIN_TYPE_PARTNER("ADMIN_TYPE_PARTNER", "파트너 관리자"),
    ADMIN_TYPE_STAY("ADMIN_TYPE_STAY", "숙박업소 관리자"),
//    ADMIN_TYPE_HOTEL("ADMIN_TYPE_HOTEL","호텔관리자"),
//    ADMIN_TYPE_PENSION("ADMIN_TYPE_PENSION","팬션관리자");
    ADMIN_TYPE_USER("ADMIN_TYPE_USER", "유저로그인");

    private String code;
    private String value;
}
