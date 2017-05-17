package com.github.frankkwok.tij4.generics;

/**
 * Page 496
 * Exercise 23: Modify FactoryConstraint.java so that create( ) takes an argument.
 *
 * @author Frank Kwok on 2017/5/17.
 */
public class FactoryConstraint {
    public static void main(String[] args) {
        new Foo2<>(new IntegerFactory());
        new Foo2<>(new Widget.Factory());
    }
}

interface FactoryI<T, S> {
    T create(S s);
}

class Foo2<T> {
    private T x;

    public <F extends FactoryI<T, Void>> Foo2(F factory) {
        x = factory.create(null);
    }
}

class IntegerFactory implements FactoryI<Integer, Void> {
    @Override
    public Integer create(Void aVoid) {
        return 0;
    }
}

class Widget {
    public static class Factory implements FactoryI<Widget, Void> {
        @Override
        public Widget create(Void aVoid) {
            return new Widget();
        }
    }
}
