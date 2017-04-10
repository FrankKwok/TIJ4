package com.github.frankkwok.tij4.reusing;

/**Page 207
 * Exercise 19: Create a class with a blank final reference to an object. Perform the initialization of the blank final
 * inside all constructors. Demonstrate the guarantee that the final must be initialized before use, and that it cannot
 * be changed once initialized.
 *
 * @author Frank Kwok on 2017/4/10.
 */
public class FinalTest2 {
    // Error:(11, 23) java: 变量 i 未在默认构造器中初始化
    private final int i;

    FinalTest2() {
        i = 5;
    }

    FinalTest2(int i) {
        this.i = i;
    }

    public static void main(String[] args) {
        FinalTest2 ft2 = new FinalTest2();
        // Error:(24, 12) java: 无法为最终变量i分配值
//        ft2.i = 10;
    }
}
