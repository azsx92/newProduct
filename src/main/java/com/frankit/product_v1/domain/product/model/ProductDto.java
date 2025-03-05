package com.frankit.product_v1.domain.product.model;

import lombok.Data;

@Data
public class ProductDto {


    @Data
    public static class common {

        private String name; // 상품 이름

        private String description; // 상품 설명

        private int price; // 상품 가격

    }

    @Data
    public static class commonC {

        private String name; // 상품 이름

        private String description; // 상품 설명

        private int price; // 상품 가격

    }

    @Data
    public static class SearchRequest {
        private Long id;
        private String name; // 상품 이름

        private String description; // 상품 설명

        private int price; // 상품 가격
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
