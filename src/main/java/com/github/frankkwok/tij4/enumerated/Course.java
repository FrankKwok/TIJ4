package com.github.frankkwok.tij4.enumerated;

import com.github.frankkwok.tij4.util.Enums;

/**
 * @author Frank Kwok on 2017/5/29.
 */
public enum Course {
    APPETIZER(Food.Appetizer.class),
    MAINCOURSE(Food.MainCourse.class),
    DESSERT(Food.Dessert.class),
    COFFEE(Food.Coffee.class),
    HUOGUO(Food.HUOGUO.class);

    private Food[] values;

    Course(Class<? extends Food> kind) {
        values = kind.getEnumConstants();
    }

    public Food randomSelection() {
        return Enums.random(values);
    }
}
