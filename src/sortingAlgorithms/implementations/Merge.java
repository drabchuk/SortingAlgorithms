package sortingAlgorithms.implementations;

import sortingAlgorithms.Sorting;

/**
 * Created by Денис on 08.05.2016.
 */
public class Merge extends Sorting {

    @Override
    public Comparable[] sort(Comparable[] a) {

        Comparable[] aux = new Comparable[a.length];
        //System.arraycopy(a, 0, aux, 0, a.length);

        mergeSort(a, aux, 0, a.length);

        return null;

    }

    private void mergeSort(Comparable[] a, Comparable[] aux, int lo, int hi) {

        if (hi == lo + 1) {
            return;
        }

        int mid = lo + (hi - lo)/2;

        mergeSort(a, aux, lo, mid);
        mergeSort(a, aux, mid, hi);

        merge(a, aux, lo, mid, hi);

    }

    private Comparable[] merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {

        System.arraycopy(a, lo, aux, lo, hi - lo);

        int i = lo;
        int j = mid;
        int counter = lo;

        while ((i < mid) && (j < hi)) {
            if (less(aux[i], aux[j])) {
                a[counter++] = aux[i++];
            } else {
                a[counter++] = aux[j++];
            }
        }

        while (i < mid) {
            a[counter++] = aux[i++];
        }
        while (j < hi) {
            a[counter++] = aux[j++];
        }
        return null;

    }
}
