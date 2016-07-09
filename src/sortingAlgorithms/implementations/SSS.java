package sortingAlgorithms.implementations;

import sortingAlgorithms.Sorting;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Денис on 18.05.2016.
 */
public class SSS extends Sorting {

    @Override
    public Comparable[] sort(Comparable[] a) {
        int length = a.length;
        Comparable[] sorted = new Comparable[length];

        LinkedList<Integer>[] graph = new LinkedList[length];

        int min = 0;

        for (int i = 0; i < length; i++) {
            graph[i] = new LinkedList<>();
        }

        for (int i = 1; i < length; i++) {
            if (less(a[i], a[min])) {
                graph[i].add(min);
                min = i;
            } else {
                graph[min].add(i);
            }
        }

        int minNeigh;
        int comNeigh;
        for (int i = 0; i < length - 1; i++) {
            minNeigh = graph[min].remove();
            while (!graph[min].isEmpty()) {
                comNeigh = graph[min].remove();
                if (less(a[comNeigh], a[minNeigh])) {
                    graph[comNeigh].add(minNeigh);
                    minNeigh = comNeigh;
                } else {
                    graph[minNeigh].add(comNeigh);
                }
            }
            sorted[i] = a[min];
            min = minNeigh;
        }

        a = sorted;
        return sorted;
    }
}
