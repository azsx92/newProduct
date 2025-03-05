package com.frankit.product_v1.domain.auth.model;

import lombok.Data;

@Data
public class UserManagerDto {
    @Data
    public static class common {
        private String username;
        private Long activated;
        private String email;
        private String mobile;
        private String name;
    }

    @Data
    public static class SearchRequest extends common{
        private Long id;
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
    public static class Response extends common{
        private Long id;
    }

    @Data
    public static class CreateRequest extends common{
        private Long id;
    }

}
