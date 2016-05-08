package sortingAlgorithms.implementations;

import sortingAlgorithms.Sorting;

/**
 * Created by Денис on 08.05.2016.
 */
public class Insertion extends Sorting {

    @Override
    public void sort(Comparable[] a) {

        int length = a.length;

        for (int i = 1; i < length; i++) {
            for (int j = i; ( (j > 0) && (less(a[j], a[j-1])) ); j--) {
                exch(a, j, j - 1);
            }
        }

    }
}
