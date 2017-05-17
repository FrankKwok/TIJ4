package com.github.frankkwok.tij4.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * Page 515
 * Exercise 29: Create a generic method that takes as an argument a Holder<List<?>>. Determine what methods you can and
 * can’t call for the Holder and for the List. Repeat for an argument of List<Holder<?>>.
 *
 * @author Frank Kwok on 2017/5/17.
 */
public class GenericTestArgumentTest {
    public static void main(String[] args) {
        f(new Holder<>(new ArrayList<>()));
        g(new ArrayList<Holder<?>>(){
            {
                add(new Holder<>(new Object()));
            }
        });
    }

    static void f(Holder<List<?>> listHolder) {
        listHolder.set(new ArrayList<String>() {
            {
                add("hello, world");
            }
        });
        List<?> list = listHolder.get();

        Object object = list.get(0);
        System.out.println(object);

//        list.set(0, new Object());
    }

    static void g(List<Holder<?>> holderList) {
        Holder<?> holder = holderList.get(0);
        Object object = holder.get();
        System.out.println(object);

//        holder.set(new Object());

        holderList.set(0, new Holder<>(new Object()));
        holderList.add(new Holder<>("hello, world"));
        System.out.println(holderList);
    }
}
