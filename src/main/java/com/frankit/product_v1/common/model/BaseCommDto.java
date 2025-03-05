package com.frankit.product_v1.common.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class BaseCommDto {
    protected LocalDateTime createdAt;
    protected String createdBy;
    protected LocalDateTime updatedAt;
    protected String updatedBy;
}
