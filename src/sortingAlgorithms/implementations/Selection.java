package sortingAlgorithms.implementations;

import sortingAlgorithms.Sorting;

/**
 * Created by Denis Drabchuck on 08.05.2016.
 */
public class Selection extends Sorting {

    @Override
    public void sort(Comparable[] a) {
        int length = a.length;
        int minIndex;

        for (int i = 0; i < length; i++) {
            minIndex = i;

            for (int j = i + 1; j < length; j++) {
                if (less(a[j], a[minIndex])) {
                    minIndex = j;
                }
            }

            exch(a, i, minIndex);
        }
    }

}
