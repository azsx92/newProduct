package com.frankit.product_v1.domain.optionValueMapping.model;

import lombok.Data;

@Data
public class OptionValueMappingDto {


    @Data
    public static class common {

        private Long optionId; // 옵션 아이디
        private Long optionValueId; // 옵션 값 아이디

    }

    @Data
    public static class commonC {


        private Long optionId; // 옵션 아이디
        private Long optionValueId; // 옵션 값 아이디

    }

    @Data
    public static class SearchRequest {
        private Long optionId; // 옵션 아이디
        private Long optionValueId; // 옵션 값 아이디
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
