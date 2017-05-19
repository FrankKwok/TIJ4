package com.github.frankkwok.tij4.containers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Page 607
 * Exercise 6: Note that List has additional "optional" operations that are not included in Collection. Write a version
 * of Unsupported.java that tests these additional optional operations.
 *
 * @author Frank Kwok on 2017/5/19.
 */
public class Unsupported {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("A B C D E F G H I J K L".split(" "));
        test("Modifiable Copy", new ArrayList<>(list));
        test("Arrays.asList()", list);
        test("unmodifiableList()", Collections.unmodifiableList(new ArrayList<>(list)));
    }

    private static void test(String msg, List<String> list) {
        System.out.println("--- " + msg + " ---");
        List<String> subList = list.subList(1, 8);
        List<String> c2 = new ArrayList<>(subList);
        try {
            list.retainAll(c2);
        } catch (Exception e) {
            System.out.println("retainAll(): " + e);
        }
        try {
            list.removeAll(c2);
        } catch (Exception e) {
            System.out.println("removeAll(): " + e);
        }
        try {
            list.clear();
        } catch (Exception e) {
            System.out.println("clear(): " + e);
        }
        try {
            list.add("X");
        } catch (Exception e) {
            System.out.println("add(): " + e);
        }
        try {
            list.add(1, "X");
        } catch (Exception e) {
            System.out.println("add(int, E): " + e);
        }
        try {
            list.addAll(c2);
        } catch (Exception e) {
            System.out.println("addAll(): " + e);
        }
        try {
            list.addAll(2, c2);
        } catch (Exception e) {
            System.out.println("addAll(int, Collection): " + e);
        }
        try {
            list.remove("C");
        } catch (Exception e) {
            System.out.println("remove(): " + e);
        }
        try {
            list.remove(1);
        } catch (Exception e) {
            System.out.println("remove(int): " + e);
        }
        try {
            list.set(0, "X");
        } catch (Exception e) {
            System.out.println("List.set(): " + e);
        }
        try {
            list.replaceAll(s -> {
                if (s.length() < 3) {
                    return s + s;
                } else {
                    return s;
                }
            });
        } catch (Exception e) {
            System.out.println("List.replaceAll(): " + e);
        }
        try {
            list.sort(String::compareToIgnoreCase);
        } catch (Exception e) {
            System.out.println("List.sort(): " + e);
        }
    }
}
