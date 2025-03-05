package com.frankit.product_v1.common.error;


import com.frankit.product_v1.common.enums.ErrorCode;
import com.frankit.product_v1.common.enums.SuccessCode;
import lombok.Getter;


@Getter
public class BaseException extends RuntimeException {

    String respCode;
    String respMessage;

    public BaseException(ErrorCode errorCode) {
        this.respCode = errorCode.getErrorCode();
        this.respMessage = errorCode.getErrorMsg();
    }

    public BaseException(SuccessCode errorCode) {
        this.respCode = errorCode.getCode();
        this.respMessage = errorCode.getValue();
    }

    public BaseException(String code, String message) {
        this.respCode = code;
        this.respMessage = message;
    }

    @Override
    public String toString() {
        return "{" +
                "respCode:'" + respCode + '\'' +
                ", respMessage:'" + respMessage + '\'' +
                '}';
    }
}
