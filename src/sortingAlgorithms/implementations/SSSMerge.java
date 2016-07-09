package sortingAlgorithms.implementations;

import sortingAlgorithms.Sorting;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * Created by Денис on 18.05.2016.
 */
public class SSSMerge extends Sorting {

    @Override
    public Comparable[] sort(Comparable[] a) {
        int length = a.length;
        Comparable[] sorted = new Comparable[length];

        LinkedList<Integer>[] graph = new LinkedList[length];
        //Set<Integer>[] graph = new Set[length];

        int min = 0;

        for (int i = 0; i < length; i++) {
            graph[i] = new LinkedList<>();
        }

        int localMinimum = 0;
        boolean isIncreased = false;
        LinkedList<Integer> localMinimumsList = new LinkedList<>();
        for (int i = 1; i < length; i++) {
            if (less(a[i - 1], a[i])) {
                if (!isIncreased) {
                    localMinimumsList.add(i - 1);
                    isIncreased = true;
                }
                if (!graph[i - 1].contains(i)) {
                    graph[i - 1].add(i);
                }
            } else {
                if (isIncreased) {
                    isIncreased = false;
                }
                if(!graph[i].contains(i - 1)) {
                    graph[i].add(i - 1);
                }
            }
        }
        //add last
        if (less(a[length - 1], a[length - 2])) {
            localMinimumsList.add(length - 1);
        }

        boolean flagIsNew = false;
        LinkedList<Integer> localMinimumsListNew = new LinkedList<>();
        //here
        while (localMinimumsList.size() > 1) {
            int leftLocalMin = localMinimumsList.remove();
            int rigthLocalMin = -1;
            int tmpLocalMin = leftLocalMin;
            isIncreased = false;
            while (!localMinimumsList.isEmpty()) {
                leftLocalMin = tmpLocalMin;
                rigthLocalMin = localMinimumsList.remove();
                if (less(a[leftLocalMin], a[rigthLocalMin])) {
                    if (!isIncreased) {
                        localMinimumsListNew.add(leftLocalMin);
                        isIncreased = true;
                    }
                    graph[leftLocalMin].add(rigthLocalMin);
                } else {
                    if (isIncreased) {
                        isIncreased = false;
                    }
                    if(!graph[rigthLocalMin].contains(leftLocalMin)) {
                        graph[rigthLocalMin].add(leftLocalMin);
                    }
                }
                tmpLocalMin = rigthLocalMin;
            }
            //add last
            if (less(a[rigthLocalMin], a[leftLocalMin])) {
                localMinimumsListNew.add(rigthLocalMin);
            }
            localMinimumsList = localMinimumsListNew;
            localMinimumsListNew = new LinkedList<>();
        }

        min = localMinimumsList.remove();

        int minNeigh;
        int comNeigh;
        for (int i = 0; i < length - 1; i++) {
            minNeigh = graph[min].remove();
            while (!graph[min].isEmpty()) {
                comNeigh = graph[min].remove();
                if (less(a[comNeigh], a[minNeigh])) {
                    if(!graph[comNeigh].contains(minNeigh)) {
                        graph[comNeigh].add(minNeigh);
                    }
                    minNeigh = comNeigh;
                } else {
                    if(!graph[minNeigh].contains(comNeigh)) {
                        graph[minNeigh].add(comNeigh);
                    }
                }
            }
            sorted[i] = a[min];
            min = minNeigh;
        }

        a = sorted;
        return sorted;
    }
}
