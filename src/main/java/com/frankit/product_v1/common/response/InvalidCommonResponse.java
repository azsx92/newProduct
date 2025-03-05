package com.frankit.product_v1.common.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InvalidCommonResponse {
    private String status;
    private String message;
    private Object data;

    public static InvalidCommonResponse success(Object data) {
        return InvalidCommonResponse.builder()
                .status("SUCCESS")
                .data(data)
                .build();
    }

    public static InvalidCommonResponse fail(String message) {
        return InvalidCommonResponse.builder()
                .status("FAIL")
                .message(message)
                .build();
    }
}
