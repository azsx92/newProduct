package com.frankit.product_v1.common.error;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponse {
    @JsonProperty("status")
    private int status;

    @JsonProperty("message")
    private String message;

    @JsonProperty("fieldDetails")
    private List<String> fieldDetails;

    public ErrorResponse(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public ErrorResponse(int status, String message, List<String> fieldDetails) {
        this.status = status;
        this.message = message;
        this.fieldDetails = fieldDetails;
    }
}
