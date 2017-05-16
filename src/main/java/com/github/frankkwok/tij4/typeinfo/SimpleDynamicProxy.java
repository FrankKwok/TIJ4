package com.github.frankkwok.tij4.typeinfo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * Page 446
 * Exercise 22: Modify SimpleDynamicProxy.java so that it measures method-call times.
 * Exercise 23: Inside invoke( ) in SimpleDynamicProxy.java, try to print the proxy argument and explain what happens.
 *
 * @author Frank Kwok on 2017/5/11.
 */
public class SimpleDynamicProxy {
    public static void main(String[] args) {
        RealObject real = new RealObject();
        consumer(real);

        System.out.println("Method doSomething invoke times: " + SimpleProxyDemo.doSomethingCount);
        System.out.println("Method somethingElse invoke times: " + SimpleProxyDemo.somethingElseCount);

        Interface proxy = (Interface) Proxy.newProxyInstance(Interface.class.getClassLoader(),
                new Class[]{Interface.class}, new DynamicProxyHandler(real));
        consumer(proxy);
        System.out.println("Method doSomething invoke times: " + SimpleProxyDemo.doSomethingCount);
        System.out.println("Method somethingElse invoke times: " + SimpleProxyDemo.somethingElseCount);
    }

    private static void consumer(Interface iface) {
        iface.doSomething();
        iface.somethingElse("bonobo");
    }
}

class DynamicProxyHandler implements InvocationHandler {
    private Object proxied;

    public DynamicProxyHandler(Object proxied) {
        this.proxied = proxied;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("**** proxy: " + proxy.getClass() + ", method: " + method + ", args: " + Arrays.toString(args));
        if (method.getName().equals("doSomething")) {
            SimpleProxyDemo.doSomethingCount++;
        }
        if (method.getName().equals("somethingElse")) {
            SimpleProxyDemo.somethingElseCount++;
        }
        return method.invoke(proxied, args);
    }
}
