package com.frankit.product_v1.domain.optionGroup.model;

import lombok.Data;

@Data
public class OptionGroupDto {


    @Data
    public static class common {

        private Long productId; // 상품 아이디

        private String name; // 옵션 그룹 명

    }

    @Data
    public static class commonC {


        private Long productId; // 상품 아이디

        private String name; // 옵션 그룹 명

    }

    @Data
    public static class SearchRequest {
        private Long id;

        private Long productId; // 상품 아이디

        private String name; // 옵션 그룹 명
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
