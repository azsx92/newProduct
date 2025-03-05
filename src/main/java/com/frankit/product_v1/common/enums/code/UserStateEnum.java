package com.frankit.product_v1.common.enums.code;


import com.frankit.product_v1.common.enums.ErrorCode;
import com.frankit.product_v1.common.error.BaseException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.LinkedHashMap;
import java.util.Map;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum UserStateEnum {

    ACTIVATED("ACTIVATED", "활성"),
    DEACTIVATED("DEACTIVATED", "비활성");


    private String code;
    private String value;

    public static UserStateEnum fromCode(String code) {
        for (UserStateEnum category : UserStateEnum.values()) {
            if (category.getCode().equals(code)) {
                return category;
            }
        }
        throw new BaseException(ErrorCode.ALARM_SMS_KIND_TYPE);
    }

    public static Map<String, String> toMap() {
        Map<String, String> map = new LinkedHashMap<>(); // HashMap -> LinkedHashMap
        for (UserStateEnum category : UserStateEnum.values()) {
            map.put(category.getCode(), category.getValue());
        }
        return map;
    }
}
