package ru.job4j.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Balancer {
    public static void split(List<ArrayList<Integer>> nodes, Iterator<Integer> source) {
        int index = 0;

        while (source.hasNext()) {
            Integer value = source.next();
            nodes.get(index).add(value);
            index++;

            if (index == nodes.size()) {
                index = 0;
            }
        }
    }
}