package com.github.frankkwok.tij4.generics;

import com.github.frankkwok.tij4.generics.coffee.Coffee;
import com.github.frankkwok.tij4.generics.coffee.CoffeeGenerator;
import com.github.frankkwok.tij4.util.Generator;

import java.util.*;

/**
 * Page 475
 * Exercise 13: Overload the fill( ) method so that the arguments and return types are the specific subtypes of
 * Collection: List, Queue and Set. This way, you don’t lose the type of container. Can you overload to distinguish
 * between List and LinkedList?
 *
 * @author Frank Kwok on 2017/5/16.
 */
public class Generators {
    public static <T> Collection<T> fill(Collection<T> coll, Generator<T> gen, int n) {
        for (int i = 0; i < n; i++) {
            coll.add(gen.next());
        }
        return coll;
    }

    public static <T> List<T> fill(List<T> list, Generator<T> gen, int n) {
        for (int i = 0; i < n; i++) {
            list.add(gen.next());
        }
        return list;
    }

    public static <T> Queue<T> fill(Queue<T> queue, Generator<T> gen, int n) {
        for (int i = 0; i < n; i++) {
            queue.offer(gen.next());
        }
        return queue;
    }

    public static <T> Stack<T> fill(Stack<T> stack, Generator<T> gen, int n) {
        for (int i = 0; i < n; i++) {
            stack.push(gen.next());
        }
        return stack;
    }

    public static <T> ArrayList<T> fill(ArrayList<T> arrayList, Generator<T> gen, int n) {
        for (int i = 0; i < n; i++) {
            arrayList.add(gen.next());
        }
        return arrayList;
    }

    public static <T> LinkedList<T> fill(LinkedList<T> linkedList, Generator<T> gen, int n) {
        for (int i = 0; i < n; i++) {
            linkedList.addFirst(gen.next());
        }
        return linkedList;
    }

    public static void main(String[] args) {
        Collection<Coffee> coffee = fill(
                new ArrayList<>(), new CoffeeGenerator(), 4);
        for (Coffee c : coffee)
            System.out.println(c);
        Collection<Integer> fnumbers = fill(
                new ArrayList<>(), new Fibonacci(), 12);
        for (int i : fnumbers)
            System.out.print(i + ", ");
    }
}
