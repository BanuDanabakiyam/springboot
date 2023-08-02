package com.springdemo.mvc.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// CourseCodeConstraintValidator => helper class that contains business rules / validation logic
// Retention => Retain this annotation in the java class file. process it at runtime.
@Constraint(validatedBy = CourseCodeConstraintValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CourseCode {
//    define default course code
    public String value() default "LUV";
//    define default error message
    public String message() default "must start with LUV";
//    define default groups
    public Class<?>[] groups() default {};
//    define default payloads
    public Class<? extends Payload>[] payload() default {};
}
// @Coursecode(value="LUV, message="must start with LUV")
