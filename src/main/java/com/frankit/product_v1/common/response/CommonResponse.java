package com.frankit.product_v1.common.response;


import com.frankit.product_v1.common.enums.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Builder(toBuilder = true)  // toBuilder 옵션 추가
@NoArgsConstructor
@AllArgsConstructor
public class CommonResponse {

    private Result result;

    private Object data;

    private String message;

    private String errorCode;

    private List<String> fieldDetails;  // New field for validation error details

    public static CommonResponse success(Object data, String message) {
        return (CommonResponse) CommonResponse.builder()
            .result(Result.SUCCESS)
            .message(message)
            .data(data)
            .build();
    }
    
    public static CommonResponse success(Object data) {
        return success(data, null);
    }

    
    public static CommonResponse fail(String message, String errorCode) {
        return CommonResponse.builder()
            .result(Result.FAIL)
            .message(message)
            .errorCode(errorCode)
            .data("")
            .build();
    }

    public static CommonResponse fail(ErrorCode errorCode) {
        return CommonResponse.builder()
            .result(Result.FAIL)
            .message(errorCode.getErrorMsg())
            .errorCode(errorCode.name())
            .data("")
            .build();
    }



    public enum Result {
        SUCCESS, FAIL
    }
}
