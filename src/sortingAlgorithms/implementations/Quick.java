package sortingAlgorithms.implementations;

import sortingAlgorithms.Sorting;

/**
 * Created by Денис on 09.05.2016.
 */
public class Quick extends Sorting {

    @Override
    public void sort(Comparable[] a) {

        quickSort(a, 0, a.length - 1);

    }

    private static void quickSort(Comparable[] a, int lo, int hi) {

        if (hi <= lo) return;

        int center = partition(a, lo, hi);

        quickSort(a, lo, center - 1);
        quickSort(a, center + 1, hi);

    }

    private static int partition(Comparable[] a, int lo, int hi) {
        int i = lo;
        int j = hi + 1;

        Comparable central = a[lo];

        while (true) {
            while (less(a[++i], central))
                if (i >= hi) break;
            while (less(central, a[--j]))
                if (j <= lo) break;

            if (j <= i) break;

            exch(a, i, j);
        }

        exch(a, lo, j);
        return j;
    }

}
