package com.frankit.product_v1.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum NationEnum {

    NATION_KOREA("ko","한국어", "LANG_KR"),
    NATION_USA("en","영어", "LANG_EN"),
    NATION_CHINA("zh-CN", "중국어(간체)", "LANG_CN"),
    NATION_JAPAN("ja", "일본어", "LANG_JP"),
    NATION_VIETNAM("vi", "베트남어", "LANG_VN"),
    NATION_ESEUPANYA("es", "스페인어", "LANG_ES");

    private String code;
    private String value;
    private String langCode;

    // code로부터 langCode 가져오기
    public static String getLangCodeByCode(String code) {
        for (NationEnum nation : NationEnum.values()) {
            if (nation.code.equals(code)) {
                return nation.langCode;
            }
        }
        // 해당 code를 가진 enum이 없을 경우 예외 처리 또는 기본 값 반환
        return null; // 또는 예외 처리나 기본 값 반환을 적절히 처리하세요.
    }

}
