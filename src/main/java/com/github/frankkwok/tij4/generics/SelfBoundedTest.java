package com.github.frankkwok.tij4.generics;

/**
 * Page 528
 * Exercise 34: Create a self-bounded generic type that contains an abstract method that takes an argument of the
 * generic type parameter and produces a return value of the generic type parameter. In a non-abstract method of the
 * class, call the abstract method and return its result. Inherit from the self-bounded type and test the resulting
 * class.
 *
 * @author Frank Kwok on 2017/5/18.
 */
public class SelfBoundedTest {
    public static void main(String[] args) {
        System.out.println(new SelfBoundedInherit(new SelfBoundedInherit(null)).produce());
    }
}

abstract class SelfBoundedBase<T> {
    private T t;

    public SelfBoundedBase(T t) {
        this.t = t;
    }

    abstract T produce(T t);

    T produce() {
        return produce(t);
    }
}

class SelfBoundedInherit extends SelfBoundedBase<SelfBoundedInherit> {
    public SelfBoundedInherit(SelfBoundedInherit selfBoundedInherit) {
        super(selfBoundedInherit);
    }

    @Override
    SelfBoundedInherit produce(SelfBoundedInherit selfBoundedInherit) {
        return selfBoundedInherit;
    }
}
