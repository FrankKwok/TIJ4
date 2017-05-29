package com.github.frankkwok.tij4.annotations.database;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface SQLInteger {
    String name() default "";

    Constraints constraints() default @Constraints;
}