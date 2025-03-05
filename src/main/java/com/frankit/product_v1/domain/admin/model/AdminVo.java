package com.frankit.product_v1.domain.admin.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AdminVo {
    private Long adminId;
    private String loginId;
    private String loginPwd;
    private String adminNm;
    private String editPassword;
    private Long hotelId;
    private Long adminLevel;
    private String adminType;
    private LocalDateTime regDt;
}
