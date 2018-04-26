package ru.tsconsulting.internship;

import java.util.concurrent.ConcurrentHashMap;

abstract class AbstractTest {
    private static final ConcurrentHashMap<Integer, Thread> map = new ConcurrentHashMap<>();

    static void put(int idx) {
        System.out.println(idx);
        map.put(idx, Thread.currentThread());
    }

    static int size() {
        return map.size();
    }

    static boolean containsKey(int idx) {
        return map.containsKey(idx);
    }

    static boolean contains(Thread th) {
        return map.contains(th);
    }

    static void clear() {
        map.clear();
    }
}
