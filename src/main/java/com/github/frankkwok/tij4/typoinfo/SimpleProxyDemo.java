package com.github.frankkwok.tij4.typoinfo;

/**
 * Page 446
 * Exercise 21: Modify SimpleProxyDemo.java so that it measures method-call times.
 *
 * @author Frank Kwok on 2017/5/11.
 */
public class SimpleProxyDemo {
    static int doSomethingCount = 0;
    static int somethingElseCount = 0;

    public static void main(String[] args) {
        consumer(new RealObject());
        System.out.println("Method doSomething invoke times: " + doSomethingCount);
        System.out.println("Method somethingElse invoke times: " + somethingElseCount);
        consumer(new SimpleProxy(new RealObject()));
        System.out.println("Method doSomething invoke times: " + doSomethingCount);
        System.out.println("Method somethingElse invoke times: " + somethingElseCount);
    }

    static void consumer(Interface iface) {
        iface.doSomething();
        iface.somethingElse("bonobo");
    }
}

interface Interface {
    void doSomething();

    void somethingElse(String arg);
}

class RealObject implements Interface {
    @Override
    public void doSomething() {
        SimpleProxyDemo.doSomethingCount++;
        System.out.println("doSomething");
    }

    @Override
    public void somethingElse(String arg) {
        SimpleProxyDemo.somethingElseCount++;
        System.out.println("somethingElse " + arg);
    }
}

class SimpleProxy implements Interface {
    private Interface proxied;

    public SimpleProxy(Interface proxied) {
        this.proxied = proxied;
    }

    @Override
    public void doSomething() {
        SimpleProxyDemo.doSomethingCount++;
        System.out.println("SimpleProxy doSomething");
        proxied.doSomething();
    }

    @Override
    public void somethingElse(String arg) {
        SimpleProxyDemo.somethingElseCount++;
        System.out.println("SimpleProxy " + arg);
        proxied.somethingElse(arg);
    }
}
