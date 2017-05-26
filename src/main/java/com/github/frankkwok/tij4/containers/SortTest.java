package com.github.frankkwok.tij4.containers;

import com.github.frankkwok.tij4.util.CollectionData;
import com.github.frankkwok.tij4.util.Generated;
import com.github.frankkwok.tij4.util.Generator;
import com.github.frankkwok.tij4.util.RandomGenerator;

import java.util.*;

/**
 * Page 658
 * Exercise 40: Create a class containing two String objects and make it Comparable so that the comparison only cares
 * about the first String. Fill an array and an ArrayList with objects of your class, using the RandomGenerator
 * generator. Demonstrate that sorting works properly. Now make a Comparator that only cares about the second String,
 * and demonstrate that sorting works properly. Also perform a binary search using your Comparator.
 * Exercise 41: Modify the class in the previous exercise so that it will work with HashSets and as a key in HashMaps.
 * Exercise 42: Modify Exercise 40 so that an alphabetic sort is used.
 *
 * @author Frank Kwok on 2017/5/26.
 */
public class SortTest {
    private static final int SIZE = 100;
    private static RandomGenerator.String gen = new RandomGenerator.String();
    private static Generator<CanSort> generator = () -> new CanSort(gen.next(), gen.next());
    private static Comparator<CanSort> comparator = Comparator.comparing(canSort -> canSort.second);

    public static void main(String[] args) {
        CanSort[] canSorts = new CanSort[SIZE];
        Generated.array(canSorts, generator);
        Arrays.sort(canSorts);
        CanSort target1 = canSorts[15];
        System.out.println(Arrays.binarySearch(canSorts, target1));

        Arrays.sort(canSorts, comparator);
        CanSort target2 = canSorts[80];
        System.out.println(Arrays.binarySearch(canSorts, target2, comparator));

        List<CanSort> canSortList = new ArrayList<>(new CollectionData<>(generator, SIZE));
        Collections.sort(canSortList);
        CanSort target3 = canSortList.get(15);
        System.out.println(Collections.binarySearch(canSortList, target3));

        canSortList.sort(comparator);
        CanSort target4 = canSortList.get(80);
        System.out.println(Collections.binarySearch(canSortList, target4, comparator));
    }
}

class CanSort implements Comparable<CanSort> {
    public final String first;
    public final String second;

    CanSort(String first, String second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) {
            return true;
        }
        if (!(otherObject instanceof CanSort)) {
            return false;
        }
        CanSort other = (CanSort) otherObject;
        return Objects.equals(first, other.first) && Objects.equals(second, other.second);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }

    @Override
    public int compareTo(CanSort other) {
        return first.compareTo(other.first);
    }
}
