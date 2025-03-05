package com.frankit.product_v1.domain.user.model;


import com.frankit.product_v1.common.annotations.NotNullOrEmpty;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserDto {


    @Data
    public static class common {

        @NotNullOrEmpty(message = "Login ID는 필수 입력 값입니다.")
        @Size(max = 255, message = "Login ID는 최대 255자 이내여야 합니다.")
        private String loginId;

        @NotNullOrEmpty(message = "Password는 필수 입력 값입니다.")
        @Size(min = 8, message = "Password는 최소 8자 이상이어야 합니다.")
        @Pattern(
                regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",
                message = "Password는 최소 8자 이상이어야 하며, 문자, 숫자, 특수 기호를 모두 포함해야 합니다."
        )
        private String password;

        @NotNullOrEmpty(message = "Mobile은 필수 입력 값입니다.")
        @Pattern(regexp = "^[0-9]{10,11}$", message = "Mobile은 10~11자리 숫자여야 합니다.")
        private String mobile;
        
        @Email(message = "유효한 Email 형식이어야 합니다.")
        private String email;

        @NotNullOrEmpty(message = "이름을 입력해 주세요.")
        @Size(max = 255, message = "Username은 최대 255자 이내여야 합니다.")
        private String userName;

        private String oauth;

        private String pushKey;

        @NotNullOrEmpty(message = "Salt는 필수 입력 값입니다.")
        private String salt;

        private String state;

        @NotNull(message = "마케팅 수신 동의 여부는 필수 입력 값입니다.")
        private Boolean marketing;

        @NotNullOrEmpty(message = "주소를 입력해 주세요.")
        @Size(max = 255, message = "Area는 최대 255자 이내여야 합니다.")
        private String address;

        private String addressDetail; // 사용자의 상세 주소

        @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$", message = "Birthdate는 yyyy-MM-dd 형식이어야 합니다.")
        private String birthdate;

        @Size(max = 255, message = "Gender는 최대 255자 이내여야 합니다.")
        private String gender;

        @Pattern(regexp = "^\\d{2}$", message = "BirthDay는 2자리 숫자여야 합니다.")
        private String birthDay;

        @Pattern(regexp = "^\\d{2}$", message = "BirthMonth는 2자리 숫자여야 합니다.")
        private String birthMonth;

        @Pattern(regexp = "^\\d{4}$", message = "BirthYear는 4자리 숫자여야 합니다.")
        private String birthYear;

        protected LocalDateTime createdAt;

        protected String createdBy;


    }

    @Data
    public static class commonC {

        @NotNullOrEmpty(message = "Login ID는 필수 입력 값입니다.")
        @Size(max = 255, message = "Login ID는 최대 255자 이내여야 합니다.")
        private String loginId;

        @NotNullOrEmpty(message = "Password는 필수 입력 값입니다.")
        @Size(min = 8, message = "Password는 최소 8자 이상이어야 합니다.")
        @Pattern(
                regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",
                message = "Password는 최소 8자 이상이어야 하며, 문자, 숫자, 특수 기호를 모두 포함해야 합니다."
        )
        private String password;

        @NotNullOrEmpty(message = "Mobile은 필수 입력 값입니다.")
        @Pattern(regexp = "^[0-9]{10,11}$", message = "Mobile은 10~11자리 숫자여야 합니다.")
        private String mobile;

        @Email(message = "유효한 Email 형식이어야 합니다.")
        private String email;

        @NotNullOrEmpty(message = "이름을 입력해 주세요.")
        @Size(max = 255, message = "Username은 최대 255자 이내여야 합니다.")
        private String userName;

        private String oauth;

        private String pushKey;

        @NotNullOrEmpty(message = "Salt는 필수 입력 값입니다.")
        private String salt;

        private String state;

        @NotNull(message = "마케팅 수신 동의 여부는 필수 입력 값입니다.")
        private Boolean marketing;

        @NotNullOrEmpty(message = "주소를 입력해 주세요.")
        @Size(max = 255, message = "Area는 최대 255자 이내여야 합니다.")
        private String address;

        private String addressDetail; // 사용자의 상세 주소

        @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$", message = "Birthdate는 yyyy-MM-dd 형식이어야 합니다.")
        private String birthdate;

        @Size(max = 255, message = "Gender는 최대 255자 이내여야 합니다.")
        private String gender;

        @Pattern(regexp = "^\\d{2}$", message = "BirthDay는 2자리 숫자여야 합니다.")
        private String birthDay;

        @Pattern(regexp = "^\\d{2}$", message = "BirthMonth는 2자리 숫자여야 합니다.")
        private String birthMonth;

        @Pattern(regexp = "^\\d{4}$", message = "BirthYear는 4자리 숫자여야 합니다.")
        private String birthYear;

        private LocalDateTime createdAt;

        private String createdBy;

    }

    @Data
    public static class SearchRequest {
        private Long id;

        private String mobile;

        private String email;

        private String userName;

        private String state ;

        private String createdAt;

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
