package com.github.frankkwok.tij4.innerclasses;

/**
 * @author Frank Kwok on 2017/4/14.
 */
public class MoreNestedClassTest {
    public static void main(String[] args) {
        NestedLevel1.NestedLevel2 nl2 = new NestedLevel1.NestedLevel2();
    }

    static class NestedLevel1 {
        static class NestedLevel2 {

        }
    }
}
