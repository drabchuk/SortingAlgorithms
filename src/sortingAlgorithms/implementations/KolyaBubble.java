package sortingAlgorithms.implementations;

import sortingAlgorithms.Sorting;

/**
 * Created by Денис on 09.07.2016.
 */
public class KolyaBubble extends Sorting {

    @Override
    public Comparable[] sort(Comparable[] a) {
        Double tmp;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - 1; j++) {
                if (less(a[j], a[j + 1])) {
                    exch(a, j ,j + 1);
                }
            }
        }
        return a;
    }
}
