package com.frankit.product_v1.domain.optionValue.model;

import lombok.Data;

@Data
public class OptionValueDto {


    @Data
    public static class common {

        private String optionValue; // 옵션 값

    }

    @Data
    public static class commonC {


        private String optionValue; // 옵션 값

    }

    @Data
    public static class SearchRequest {
        private String optionValue; // 옵션 값
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
