package com.frankit.product_v1.common.error;

public enum LoginErrorCode implements IErrorCode {

    LOGIN_ERROR("401", "인증 실패"),
    FORBIDDEN("403", "인가 실패"),

    AUTH_INVALID_SIGNATURE("401","시그니처 오류"),
    AUTH_INVALID_TOKEN("401","유효하지 않은 JWT 토큰"),
    AUTH_TOKEN_EXPIRATION("401","토큰 기한 만료"),
    AUTH_TOKEN_UNSUPPORTED("401","지원되지 않는 JWT 형식"),
    AUTH_TOKEN_COMPACT("401","JWT token compact of handler are invalid."),
    AUTH_TOKEN_CREATION_ERROR("401", "JWT 토큰 생성 과정에서 문제가 발생했습니다.");

    private String status;
    private String value;
    private Boolean isError = false;

    LoginErrorCode(String status, String value) {
        this.status = status;
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public String getStatus() {
        return status;
    }

    public Boolean getIsError() {
        return isError;
    }
}
