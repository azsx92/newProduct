package com.frankit.product_v1.common.annotations;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = NotNullOrEmptyValidator.class) // Specify the validator class
@Target({ ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface NotNullOrEmpty {
    String message() default "This field cannot be null or empty";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}