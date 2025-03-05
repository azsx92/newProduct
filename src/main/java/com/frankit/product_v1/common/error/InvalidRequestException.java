package com.frankit.product_v1.common.error;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class InvalidRequestException extends RuntimeException {

    String status;
    String message;

    public Body getBody() {
        return new Body(this);
    }

    public InvalidRequestException(IErrorCode errorCode) {
        this.status = errorCode.getStatus();
        this.message = errorCode.getValue();
    }

    public static class Body {
        String status;
        String message;

        public Body(InvalidRequestException e) {
            this.status = e.getStatus();
            this.message = e.getMessage();
        }
    }
}
