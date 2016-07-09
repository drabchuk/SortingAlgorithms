package sortingAlgorithms.implementations;

import sortingAlgorithms.Sorting;

/**
 * Created by Денис on 09.07.2016.
 */
public class VladBubble extends Sorting {

    @Override
    public Comparable[] sort(Comparable[] a) {
        boolean swap;
        do {
            swap = false;
            for (int i = 1; i < a.length; i++) {
                if (less(a[i - 1], a[i])) {
                    double temp;
                    exch(a, i, i - 1);
                    swap = true;
                }
            }
        } while (swap);

        return a;
    }
}
