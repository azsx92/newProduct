package com.frankit.product_v1.domain.admin.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class AdminDto {

    @NotBlank(message = "ID는 필수입니다.")
    @NotBlank(message = "ID는 필수입니다.")
    private String username;
    private String name;
    @NotBlank(message = "비밀번호는 필수입니다.")
    @NotEmpty(message = "비밀번호는 필수입니다.")
    private String password;
    private String state;
    private String auth;
    private String kind;

    @Data
    public static class CreateAdmin {
        @NotBlank(message = "ID는 필수입니다.")
        @NotEmpty(message = "ID는 필수입니다.")
        private String username;
//        @NotBlank(message = "비밀번호는 필수입니다.")
//        @NotEmpty(message = "비밀번호는 필수입니다.")
//        private String loginPwd;
    }

    @Data
    public static class UpdateAdmin {
        @NotBlank(message = "ID는 필수입니다.")
        @NotEmpty(message = "ID는 필수입니다.")
        private String username;
        @NotBlank(message = "비밀번호는 필수입니다.")
        @NotEmpty(message = "비밀번호는 필수입니다.")
        private String password;
    }
}
