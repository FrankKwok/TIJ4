package com.github.frankkwok.tij4.containers;

import com.github.frankkwok.tij4.util.Countries;

import java.util.*;

/**
 * Page 601
 * Exercise 1: Create a List (try both ArrayList and LinkedList) and fill it using Countries. Sort the list and print
 * it, then apply Collections.shuffle( ) to the list repeatedly, printing it each time so that you can see how the
 * shuffle( ) method randomizes the list differently each time.
 * <p>
 * Page 610
 * Exercise 7: Create both an ArrayList and a LinkedList, and fill each using the Countries.names( ) generator.
 * Print each list using an ordinary Iterator, then insert one list into the other by using a Listlterator, inserting
 * at every other location. Now perform the insertion starting at the end of the first list and moving backward.
 * Exercise 8: Create a generic, singly linked list class called SList, which, to keep things simple, does not implement
 * the List interface. Each Link object in the list should contain a reference to the next element in the list, but not
 * the previous one (LinkedList, in contrast, is a doubly linked list, which means it maintains links in both
 * directions). Create your own SListIterator which, again for simplicity, does not implement ListIterator. The only
 * method in SList other than toString( ) should be iterator( ), which produces an SListIterator. The only way to insert
 * and remove elements from an SList is through SListIterator. Write code to demonstrate SList.
 *
 * @author Frank Kwok on 2017/5/19.
 */
public class ListTest {
    public static void main(String[] args) {
        System.out.println("ArrayList: ");
        List<String> list = new ArrayList<>(Countries.names(5));
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
        Collections.shuffle(list);
        System.out.println(list);

        System.out.println("LinkedList: ");
        list = new LinkedList<>(Countries.names(6));
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
        Collections.shuffle(list);
        System.out.println(list);

        List<String> arrayList = new ArrayList<>(Countries.names(7));
        List<String> linkedList = new LinkedList<>(Countries.names(8));
        Iterator<String> at = arrayList.iterator();
        while (at.hasNext()) {
            System.out.print(at.next() + ", ");
        }
        System.out.println();
        Iterator<String> lt = linkedList.iterator();
        while (lt.hasNext()) {
            System.out.print(lt.next() + ", ");
        }
        System.out.println();

        ListIterator<String> alt = arrayList.listIterator(arrayList.size());
        ListIterator<String> llt = linkedList.listIterator();
        while (llt.hasNext()) {
            if (alt.hasPrevious()) {
                alt.previous();
            }
            alt.add(llt.next());
            alt.previous();
        }
        System.out.println(arrayList);

        SList<String> sList = new SList<>();
        SList<String>.SListIterator iterator = sList.iterator();
        iterator.insert("ABC");
        iterator.insert("EFG");
        iterator.insert("HIJ");
        System.out.println(sList);
    }
}

class SList<E> {
    Link<E> link = new Link<>(null);

    public SList() {

    }

    SListIterator iterator() {
        return new SListIterator();
    }

    @Override
    public String toString() {
        if (link.next == null) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder("[");
        SListIterator it = new SListIterator();
        while (it.hasNext()) {
            sb.append(it.next());
            sb.append(", ");
        }
        return sb.delete(sb.length() - 2, sb.length()).append("]").toString();
    }

    class SListIterator {
        Link<E> current = link;

        boolean hasNext() {
            return current.next != null;
        }

        E next() {
            current = current.next;
            return current.e;
        }

        void insert(E e) {
            current.next = new Link<>(e, current.next);
        }

        void remove() {
            current.next = current.next.next;
        }
    }
}

class Link<E> {
    E e;
    Link<E> next;

    Link(E e) {
        this(e, null);
    }

    Link(E e, Link<E> next) {
        this.e = e;
        this.next = next;
    }

    @Override
    public String toString() {
        if (e == null) {
            return "null";
        } else {
            return e.toString();
        }
    }
}
