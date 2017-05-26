package com.github.frankkwok.tij4.containers;

/**
 * @author Frank Kwok on 2017/5/26.
 */
public abstract class Test<C> {
    String name;

    public Test(String name) {
        this.name = name;
    }

    abstract int test(C container, TestParam tp);
}
