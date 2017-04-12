package com.github.frankkwok.tij4.interfaces;

/**
 * Page 258
 * Exercise 17: Prove that the fields in an interface are implicitly static and final.
 *
 * @author Frank Kwok on 2017/4/12.
 */
public interface InterfaceField {
    int i = 5;

    static void main(String[] args) {
        NormalClass nc1 = new NormalClass();
        NormalClass nc2 = new NormalClass();
        System.out.println(nc1.i == nc2.i);
        // Error:(16, 12) java: 无法为最终变量i分配值
//        nc1.i = 7;
    }
}

class NormalClass implements InterfaceField {

}
