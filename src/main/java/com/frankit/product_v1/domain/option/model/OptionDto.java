package com.frankit.product_v1.domain.option.model;


import com.frankit.product_v1.common.enums.code.OptionTypeEnum;
import lombok.Data;

@Data
public class OptionDto {


    @Data
    public static class common {

        private Long optionGroupId; // 옵션 그룹 아이디

        private String optionName; // 옵션 명

        private OptionTypeEnum optionType;

    }

    @Data
    public static class commonC {


        private Long optionGroupId; // 옵션 그룹 아이디

        private String optionName; // 옵션 명

        private OptionTypeEnum optionType;

    }

    @Data
    public static class SearchRequest {
        private Long optionGroupId; // 옵션 그룹 아이디

        private String optionName; // 옵션 명

        private OptionTypeEnum optionType;
    }
    @Data
    public static class UpdateRequest extends common{
        private Long id;
    }
    @Data
    public static class DeleteRequest extends common{
        private Long id;
    }

    @Data
    public static class Response extends commonC{
        private Long id;

    }
}
