package com.darian.core.log;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *  TYPE ->  Class, interface (including annotation type), or enum declaration
 *  METHOD ->  Method declaration
 */
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface LogCustom {

    String value() default "";

    boolean ignore() default false;
}
