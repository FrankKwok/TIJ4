package com.github.frankkwok.tij4.typeinfo;

import com.github.frankkwok.tij4.generics.coffee.Coffee;
import com.github.frankkwok.tij4.generics.coffee.CoffeeGenerator;
import com.github.frankkwok.tij4.util.TypeCounter;

/**
 * Page 435
 * Exercise 12: Use TypeCounter with the CoffeeGenerator.java class in the Generics chapter.
 * <p>
 * Page 438
 * Exercise 16: Modify the Coffee hierarchy in the Generics chapter to use Registered Factories.
 *
 * @author Frank Kwok on 2017/5/11.
 */
public class CoffeeCount {
    public static void main(String[] args) {
        TypeCounter typeCounter = new TypeCounter(Coffee.class);
        for (Coffee coffee : new CoffeeGenerator(20)) {
            System.out.print(coffee.getClass().getSimpleName() + " ");
            typeCounter.count(coffee);
        }
        System.out.println();
        System.out.println(typeCounter);
    }
}
