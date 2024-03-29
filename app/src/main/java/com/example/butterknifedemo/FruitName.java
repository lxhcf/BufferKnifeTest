package com.example.butterknifedemo;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.LOCAL_VARIABLE)
@Retention(RetentionPolicy.SOURCE)
@Documented
public @interface FruitName {
    String value() default "12";
}
