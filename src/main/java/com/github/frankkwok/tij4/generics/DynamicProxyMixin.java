package com.github.frankkwok.tij4.generics;

import com.github.frankkwok.tij4.util.TwoTuple;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

/**
 * Page 536
 * Exercise 39: Add a new mixin class Colored to DynamicProxyMixin.java, mix it into mixin, and show that it works.
 *
 * @author Frank Kwok on 2017/5/18.
 */
public class DynamicProxyMixin {
    public static void main(String[] args) {
        Object object = MixinProxy.newInstance(new TwoTuple<Object, Class<?>>(new TimeStampedImp(), TimeStamped.class),
                new TwoTuple<Object, Class<?>>(new SerialNumberedImp(), SerialNumbered.class),
                new TwoTuple<Object, Class<?>>(new BasicImp(), Basic.class),
                new TwoTuple<Object, Class<?>>(new ColoredImpl(), Colored.class));
        TimeStamped timeStamped = (TimeStamped) object;
        SerialNumbered serialNumbered = (SerialNumbered) object;
        Basic basic = (Basic) object;
        Colored colored = (Colored) object;
        basic.set("Hello");
        System.out.println(basic.get());
        System.out.println(timeStamped.getStamp());
        System.out.println(serialNumbered.getSerialNumber());
        System.out.println(colored.getColor());
    }
}

class MixinProxy implements InvocationHandler {
    Map<String, Object> delegatesByMethod;

    @SuppressWarnings("unchecked")
    public MixinProxy(TwoTuple<Object, Class<?>>... pairs) {
        delegatesByMethod = new HashMap<>();
        for (TwoTuple<Object, Class<?>> pair : pairs) {
            for (Method method : pair.second.getMethods()) {
                String methodName = method.getName();
                if (!delegatesByMethod.containsKey(methodName))
                    delegatesByMethod.put(methodName, pair.first);
            }
        }
    }

    public Object invoke(Object proxy, Method method,
                         Object[] args) throws Throwable {
        String methodName = method.getName();
        Object delegate = delegatesByMethod.get(methodName);
        return method.invoke(delegate, args);
    }

    @SuppressWarnings("unchecked")
    public static Object newInstance(TwoTuple... pairs) {
        Class[] interfaces = new Class[pairs.length];
        for (int i = 0; i < pairs.length; i++) {
            interfaces[i] = (Class) pairs[i].second;
        }
        ClassLoader cl =
                pairs[0].first.getClass().getClassLoader();
        return Proxy.newProxyInstance(
                cl, interfaces, new MixinProxy(pairs));
    }
}
