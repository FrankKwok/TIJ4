package com.github.frankkwok.tij4.concurrency;

import com.github.frankkwok.tij4.util.CountingGenerator;
import com.github.frankkwok.tij4.util.MapData;

import java.util.concurrent.*;
import java.util.*;


/**
 * Page 947
 * Exercise 40: Following the example of ReaderWriterList.java, create a ReaderWriterMap using a HashMap. Investigate
 * its performance by modifying MapComparisons.java. How does it compare to a synchronized HashMap and a
 * ConcurrentHashMap?
 */
public class MapComparisons {
    public static void main(String[] args) {
        Tester.initMain(args);
        new SynchronizedHashMapTest(10, 0);
        new SynchronizedHashMapTest(9, 1);
        new SynchronizedHashMapTest(5, 5);
        new ConcurrentHashMapTest(10, 0);
        new ConcurrentHashMapTest(9, 1);
        new ConcurrentHashMapTest(5, 5);
        new ReaderWriterMapTest(10, 0);
        new ReaderWriterMapTest(9, 1);
        new ReaderWriterMapTest(5, 5);
        Tester.exec.shutdown();
    }
}

abstract class MapTest extends Tester<Map<Integer, Integer>> {
    MapTest(String testId, int nReaders, int nWriters) {
        super(testId, nReaders, nWriters);
    }

    class Reader extends TestTask {
        long result = 0;

        @Override
        void test() {
            for (long i = 0; i < testCycles; i++)
                for (int index = 0; index < containerSize; index++) {
                    result += testContainer.get(index);
                }
        }

        @Override
        void putResults() {
            readResult += result;
            readTime += duration;
        }
    }

    class Writer extends TestTask {
        @Override
        void test() {
            for (long i = 0; i < testCycles; i++)
                for (int index = 0; index < containerSize; index++) {
                    testContainer.put(index, writeData[index]);
                }
        }

        @Override
        void putResults() {
            writeTime += duration;
        }
    }

    @Override
    void startReadersAndWriters() {
        for (int i = 0; i < nReaders; i++) {
            exec.execute(new Reader());
        }
        for (int i = 0; i < nWriters; i++) {
            exec.execute(new Writer());
        }
    }
}

class SynchronizedHashMapTest extends MapTest {
    SynchronizedHashMapTest(int nReaders, int nWriters) {
        super("Synched HashMap", nReaders, nWriters);
    }

    @Override
    Map<Integer, Integer> containerInitializer() {
        return Collections.synchronizedMap(
                new HashMap<>(
                        MapData.map(new CountingGenerator.Integer(),
                                new CountingGenerator.Integer(),
                                containerSize)));
    }
}

class ConcurrentHashMapTest extends MapTest {
    ConcurrentHashMapTest(int nReaders, int nWriters) {
        super("ConcurrentHashMap", nReaders, nWriters);
    }

    @Override
    Map<Integer, Integer> containerInitializer() {
        return new ConcurrentHashMap<>(
                MapData.map(
                        new CountingGenerator.Integer(),
                        new CountingGenerator.Integer(),
                        containerSize));
    }
}

class ReaderWriterMapTest extends MapTest {
    ReaderWriterMapTest(int nReaders, int nWriters) {
        super("ReaderWriterMap", nReaders, nWriters);
    }

    @Override
    Map<Integer, Integer> containerInitializer() {
        return new ReaderWriterMap<>(
                MapData.map(
                        new CountingGenerator.Integer(),
                        new CountingGenerator.Integer(),
                        containerSize));
    }
}