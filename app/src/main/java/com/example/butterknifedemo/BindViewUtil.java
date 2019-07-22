package com.example.butterknifedemo;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.TYPE;

/**
 * Target元注解表示自定义注解能应用在那些java元素上
 * Retention:决定自定义注解的生命周期
 *
 */
// @Retention(RetentionPolicy.RUNTIME)
//@Target(value = {ElementType.METHOD})
//@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(FIELD)
@Documented
public @interface BindViewUtil {
    int id() default 0;
}
