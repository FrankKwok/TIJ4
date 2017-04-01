package com.github.frankkwok.tij4.object;

/**
 * Page 61
 * <p>
 * Exercise 2: Following the HelloDate.java example in this chapter, create a “hello, world” program that simply
 * displays that statement. You need only a single method in your class (the “main” one that gets executed when the
 * program starts). Remember to make it static and to include the argument list, even though you don’t use the argument
 * list. Compile the program with javac and run it using java. If you are using a different development environment than
 * the JDK, learn how to compile and run programs in that environment.
 * Exercise 15: Take the program in Exercise 2 and add comment documentation to it. Extract this comment documentation
 * into an HTML file using Javadoc and view it with your Web browser.
 *
 * @author Frank Kwok on 2017/4/1.
 */
public class HelloWorld {
    /**
     * print a greeting to the world
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("hello, world");
    }
}
