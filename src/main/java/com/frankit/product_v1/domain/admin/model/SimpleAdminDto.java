package com.frankit.product_v1.domain.admin.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class SimpleAdminDto {

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SearchAdmin {
        private String username;
    }
}
