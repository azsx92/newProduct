package com.frankit.product_v1.common.enums.works;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum WorksEnum {

        STATUS_NON_OPERATION("0", "미운영"),
        STATUS_OPERATION("1", "운영"),
        STATUS_DELETE("99", "삭제"),

        // 서비스 상세 구분
        SV_HOTEL_AMENITIES("SV_HOTEL_AMENITIES","호텔용품"),
        SV_ROOM_SERVICE("SV_ROOM_SERVICE","룸서비스"),
        SV_SHOP("SV_SHOP","상점"),
        SV_DELIVERY("SV_DELIVERY","룸딜리버리"),
        SV_VALET("SV_VALET","출차요청"),
        SV_CALL_TAXI("SV_CALL_TAXI","택시호출"),
        SV_NEARBY_STORES("SV_NEARBY_STORES","주변상점"),
        SV_MEMBERSHIP_QR("SV_MEMBERSHIP_QR","QR 이미지"),
        SV_HOTEL_INFO_IMAGE("SV_HOTEL_INFO_IMAGE","이미지"),
        SV_MEMBERSHIP("SV_MEMBERSHIP","웹링크"),
        SV_WEBVIEW("SV_WEBVIEW","웹링크"),
        SV_FRONT_CALL("SV_FRONT_CALL","직원호출"),
        SV_EMERGENCY_CALL("SV_EMERGENCY_CALL","비상호출"),
        SV_WEATHER("SV_WEATHER","웹링크"),
        SV_SURVEY("SV_SURVEY","웹링크"),
        SV_ALARM("SV_ALARM","알람"),
        SV_MAINTENANCE("SV_MAINTENANCE","객실정비"),
        SV_CHECKOUT("SV_CHECKOUT","체크아웃"),
        SV_DELIVERY_GROUP("SV_DELIVERY_GROUP","딜리버리"),
        SV_DELIVERY_ITEM("SV_DELIVERY_ITEM","주변상점"),
        SV_PICKUP_GROUP("SV_PICKUP_GROUP","픽업"),
        SV_PICKUP_ITEM("SV_PICKUP_ITEM","주변상점");

    private String code;
    private String value;

}
