package com.github.frankkwok.tij4.enumerated;

/**
 * Page 759
 * Exercise 6: Is there any special benefit in nesting Appetizer, MainCourse, Dessert, and Coffee inside Food rather
 * than making them standalone enums that just happen to implement Food?
 * <p>
 * 放在一起方便组织代码，可以通过反射找到Food的嵌套类(class.getDeclaredClasses())
 *
 * @author Frank Kwok on 2017/5/29.
 */
public interface Food {
    enum Appetizer implements Food {
        SALAD, SOUP, SPRING_ROLLS
    }

    enum MainCourse implements Food {
        LASAGNE, BURRITO, PAD_THAI,
        LENTILS, HUMMOUS, VINDALOO
    }

    enum Dessert implements Food {
        TIRAMISU, GELATO, BLACK_FOREST_CAKE,
        FRUIT, CREME_CARAMEL
    }

    enum Coffee implements Food {
        BLACK_COFFEE, DECAF_COFFEE, ESPRESSO,
        LATTE, CAPPUCCINO, TEA, HERB_TEA
    }

    enum HUOGUO implements Food {
        SICUAN_HUOGUO, CHONGQING_HUOGUO, CHAOSHAN_HUOGUO
    }
}
