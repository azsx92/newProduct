package com.frankit.product_v1.config;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.frankit.product_v1.common.response.CommonResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import java.util.List;
import java.util.stream.Collectors;


@Configuration
public class GlobalExceptionConfig {

    @Bean
    public HandlerExceptionResolver validationExceptionResolver() {
        return (request, response , handler , ex) -> {
            if (ex instanceof MethodArgumentNotValidException) {
                MethodArgumentNotValidException validationEx = (MethodArgumentNotValidException) ex;


                // Collecting validation error messages
                List<String> fieldDetails = validationEx.getBindingResult()
                        .getFieldErrors()
                        .stream()
                        .map(this::formatFieldError)
                        .collect(Collectors.toList());

                // Set the response status and content type
                response.setStatus(400);
                response.setContentType("application/json");

                // Create the error response as CommonResponse
                CommonResponse commonResponse = CommonResponse.fail("Validation Failed", "400")
                        .toBuilder()
                        .fieldDetails(fieldDetails)
                        .build();

                // Write the response as JSON
                try {
                    String jsonResponse = new ObjectMapper().writeValueAsString(commonResponse);
                    response.getWriter().write(jsonResponse);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                return new ModelAndView(); // Return an empty ModelAndView to indicate no further processing
            }
            // 처리되지 않은 예외는 null로 반환 (다른 Resolver로 넘어감)
            return null;
        };
    }

   // Validation 오류 메시지 커스터마이징
    private String formatFieldError(FieldError error) {
        return String.format("Field '%s' %s", error.getField(), error.getDefaultMessage());
    }

    @Bean
    public SimpleMappingExceptionResolver exceptionResolver() {
        SimpleMappingExceptionResolver resolVer = new SimpleMappingExceptionResolver();
        return resolVer;
    };
}


