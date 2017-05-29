package com.github.frankkwok.tij4.annotations.database;

public @interface Uniqueness {
  Constraints constraints()
    default @Constraints(unique=true);
}
