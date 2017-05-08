package com.github.frankkwok.tij4.holding;

import java.util.*;

/**
 * Page 308
 * Exercise 5: Modify ListFeatures.java so that it uses Integers (remember autoboxing!) instead of Pets, and explain any
 * difference in results.
 * Exercise 6: Modify ListFeatures.java so that it uses Strings instead of Pets, and explain any difference in results.
 *
 * @author Frank Kwok on 2017/4/23.
 */
public class ListFeatures {
    public static void main(String[] args) {
        // Integer
        Integers.main(args);
        // String
        Strings.main(args);
    }
}

class Integers {
    public static void main(String[] args) {
        // Integer
        Random rand = new Random(47);
        List<Integer> integers = Integers.arrayList(7);
        System.out.println("1: " + integers);
        Integer two = 2;
        integers.add(two);
        System.out.println("2: " + integers);
        System.out.println("3: " + integers.contains(two));
        integers.remove(two);
        Integer i = integers.get(2);
        System.out.println("4: " + i + " " + integers.indexOf(i));
        Integer five = 5;
        System.out.println("5: " + integers.indexOf(five));
        System.out.println("6: " + integers.remove(five));
        System.out.println("7: " + integers.remove(i));
        System.out.println("8: " + integers);
        integers.add(3, 9);
        System.out.println("9: " + integers);
        List<Integer> sub = integers.subList(1, 4);
        System.out.println("subList: " + sub);
        System.out.println("10: " + integers.containsAll(sub));
        Collections.sort(sub);
        System.out.println("sorted subList: " + sub);
        System.out.println("11: " + integers.containsAll(sub));
        Collections.shuffle(sub, rand);
        System.out.println("shuffled subList: " + sub);
        System.out.println("12: " + integers.containsAll(sub));
        List<Integer> copy = new ArrayList<>(integers);
        sub = Arrays.asList(integers.get(1), integers.get(4));
        System.out.println("sub: " + sub);
        copy.retainAll(sub);
        System.out.println("13: " + copy);
        copy = new ArrayList<>(integers);
        copy.remove(2);
        System.out.println("14: " + copy);
        copy.removeAll(sub);
        System.out.println("15: " + copy);
        copy.set(1, 16);
        System.out.println("16: " + copy);
        copy.addAll(2, sub);
        System.out.println("17: " + copy);
        System.out.println("18: " + integers.isEmpty());
        integers.clear();
        System.out.println("19: " + integers);
        System.out.println("20: " + integers.isEmpty());
        integers.addAll(Integers.arrayList(4));
        System.out.println("21: " + integers);
        Object[] o = integers.toArray();
        System.out.println("22: " + o[3]);
        Integer[] pa = integers.toArray(new Integer[0]);
        System.out.println("23: " + pa[3]);

        // String
    }

    static ArrayList<Integer> arrayList(int num) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            arrayList.add((int) (Math.random() * 100));
        }
        return arrayList;
    }
}

class Strings {
    public static void main(String[] args) {
        Random rand = new Random(47);
        List<String> strings = Strings.arrayList(7);
        System.out.println("1: " + strings);
        String string2 = "string #2";
        strings.add(string2);
        System.out.println("2: " + strings);
        System.out.println("3: " + strings.contains(string2));
        strings.remove(string2);
        String i = strings.get(2);
        System.out.println("4: " + i + " " + strings.indexOf(i));
        String string5 = "string #5";
        System.out.println("5: " + strings.indexOf(string5));
        System.out.println("6: " + strings.remove(string5));
        System.out.println("7: " + strings.remove(i));
        System.out.println("8: " + strings);
        strings.add(3, "string #9");
        System.out.println("9: " + strings);
        List<String> subStrings = strings.subList(1, 4);
        System.out.println("subList: " + subStrings);
        System.out.println("10: " + strings.containsAll(subStrings));
        Collections.sort(subStrings);
        System.out.println("sorted subList: " + subStrings);
        System.out.println("11: " + strings.containsAll(subStrings));
        Collections.shuffle(subStrings, rand);
        System.out.println("shuffled subList: " + subStrings);
        System.out.println("12: " + strings.containsAll(subStrings));
        List<String> copy = new ArrayList<>(strings);
        subStrings = Arrays.asList(strings.get(1), strings.get(4));
        System.out.println("subStrings: " + subStrings);
        copy.retainAll(subStrings);
        System.out.println("13: " + copy);
        copy = new ArrayList<>(strings);
        copy.remove(2);
        System.out.println("14: " + copy);
        copy.removeAll(subStrings);
        System.out.println("15: " + copy);
        copy.set(1, "string #16");
        System.out.println("16: " + copy);
        copy.addAll(2, subStrings);
        System.out.println("17: " + copy);
        System.out.println("18: " + strings.isEmpty());
        strings.clear();
        System.out.println("19: " + strings);
        System.out.println("20: " + strings.isEmpty());
        strings.addAll(Strings.arrayList(4));
        System.out.println("21: " + strings);
        Object[] o = strings.toArray();
        System.out.println("22: " + o[3]);
        String[] pa = strings.toArray(new String[0]);
        System.out.println("23: " + pa[3]);
    }

    private static ArrayList<String> arrayList(int num) {
        ArrayList<Integer> integers = Integers.arrayList(num);
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            arrayList.add("string #" + integers.get(i));
        }
        return arrayList;
    }
}
