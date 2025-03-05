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
public enum OptionTypeEnum {

    SELECT("SELECT", "선택"),
    INPUT("INPUT", "입력형");


    private String code;
    private String value;

    public static OptionTypeEnum fromCode(String code) {
        for (OptionTypeEnum category : OptionTypeEnum.values()) {
            if (category.getCode().equals(code)) {
                return category;
            }
        }
        throw new BaseException(ErrorCode.OPTION_KIND_TYPE);
    }

    public static Map<String, String> toMap() {
        Map<String, String> map = new LinkedHashMap<>(); // HashMap -> LinkedHashMap
        for (OptionTypeEnum category : OptionTypeEnum.values()) {
            map.put(category.getCode(), category.getValue());
        }
        return map;
    }
}
