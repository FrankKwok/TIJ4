package com.github.frankkwok.tij4.annotations.database;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Page 793
 * Exercise 1: Implement more SQL types in the database example.
 *
 * @author Frank Kwok on 2017/5/29.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface SQLDouble {
    String name() default "";

    Constraints constraints() default @Constraints;
}
