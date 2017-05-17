package com.github.frankkwok.tij4.generics;

import com.github.frankkwok.tij4.typeinfo.pets.Cat;
import com.github.frankkwok.tij4.typeinfo.pets.Pet;

/**
 * Page 510
 * Exercise 28: Create a generic class Generic1<T> with a single method that takes an argument of type T. Create a
 * second generic class Generic2<T> with a single method that returns an argument of type T. Write a generic method with
 * a contravariant argument of the first generic class that calls its method. Write a second generic method with a
 * covariant argument of the second generic class that calls its method. Test using the typeinfo.pets library.
 *
 * @author Frank Kwok on 2017/5/17.
 */
public class ContravarianceTest {
    public static void main(String[] args) {
        f(new Generic1<Pet>(), new Cat());
        System.out.println(g(new Generic2<Pet>(Cat.class)));
    }

    static <T> void f(Generic1<? super T> g1, T t) {
        g1.apply(t);
    }

    static <T> T g(Generic2<? extends T> g2) {
        return g2.get();
    }
}

class Generic1<T> {
    void apply(T t) {
        System.out.println(t);
    }
}

class Generic2<T> {
    private Class<? extends T> clazz;

    public Generic2(Class<? extends T> clazz) {
        this.clazz = clazz;
    }

    T get() {
        try {
            return clazz.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
