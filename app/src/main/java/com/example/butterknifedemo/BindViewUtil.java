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
 * - ElementType.FIELD 可以给属性进行注解
 * - ElementType.LOCAL_VARIABLE 可以给局部变量进行注解
 * - ElementType.METHOD 可以给方法进行注解
 * - ElementType.TYPE 可以给一个类型进行注解，比如类、接口、枚举
 *
 * Retention:决定自定义注解的保留多久
 * - RetentionPolicy.SOURCE 注解只在源码阶段保留，在编译器进行编译时它将被丢弃忽视。
 * - RetentionPolicy.CLASS 注解只被保留到编译进行的时候，它并不会被加载到 JVM 中。
 * - RetentionPolicy.RUNTIME 注解可以保留到程序运行的时候，它会被加载进入到 JVM 中，所以在程序运行时可以获取到它们。
 *
 * Documented:将注解中的元素包含到 Javadoc
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
