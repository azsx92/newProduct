package com.frankit.product_v1.common.annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NotNullOrEmptyValidator implements ConstraintValidator<NotNullOrEmpty, String> {
    @Override
    public void initialize(NotNullOrEmpty constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value != null && !value.trim().isEmpty();
    }
}
