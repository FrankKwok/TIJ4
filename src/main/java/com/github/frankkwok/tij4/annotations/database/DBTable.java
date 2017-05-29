package com.github.frankkwok.tij4.annotations.database;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface DBTable {
    String name() default "";
}
