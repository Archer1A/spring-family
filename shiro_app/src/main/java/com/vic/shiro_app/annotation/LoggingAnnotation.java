package com.vic.shiro_app.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * LoggingAnnotation
 *
 * @author Vic
 * @date 2019/5/31
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface LoggingAnnotation {
    String name() default "";

}
