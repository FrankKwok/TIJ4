package com.github.frankkwok.tij4.reusing;

/**
 * Page 212
 * Exercise 23: Prove that class loading takes place only once. Prove that loading may be caused by either the creation
 * of the first instance of that class or by the access of a static member.
 *
 * @author Frank Kwok on 2017/4/10.
 */
public class ClassLoadingTest {
    public static void main(String[] args) {
        System.out.println("access of a static member");
        System.out.println(ClassLoading.i);
        System.out.println("the creation of the first instance of that class");
        new ClassLoading();
    }
}

class ClassLoading {
    static int i;

    static {
        System.out.println("Loading class");
    }


}
