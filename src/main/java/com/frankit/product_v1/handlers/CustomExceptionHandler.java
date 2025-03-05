package com.frankit.product_v1.handlers;

import com.frankit.product_v1.common.error.BaseException;
import com.frankit.product_v1.common.error.ErrorResponse;
import com.frankit.product_v1.common.error.InvalidRequestException;
import com.frankit.product_v1.common.response.CommonResponse;
import com.frankit.product_v1.common.response.InvalidCommonResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        List<String> details = new ArrayList<>();
        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            details.add(error.getField() + " : " + error.getDefaultMessage());
        }

        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), "Validation Failed", details);
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BaseException.class)
    @ResponseBody
    public CommonResponse handleBaseException(BaseException ex) {
        return CommonResponse.fail(ex.getRespMessage(), ex.getRespCode());
    }

    /**
     * InvalidRequestException 처리
     * 장애 상황이 아니고, 요청 파라미터가 잘못된 경우
     *
     * @param ex
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = InvalidRequestException.class)
    public InvalidCommonResponse handleInvalidRequestException(InvalidRequestException ex) {
        return InvalidCommonResponse.builder().message(ex.getMessage()).status(ex.getStatus())
                .build();
    }


//    @ExceptionHandler(Exception.class)
//    @ResponseBody
//    public CommonResponse handleBaseException(Exception ex) {
//
//        return CommonResponse.fail(ex.getRespMessage(), ex.getRespCode());
//    }
}
