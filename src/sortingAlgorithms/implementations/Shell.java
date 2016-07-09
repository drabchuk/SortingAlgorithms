package sortingAlgorithms.implementations;

import sortingAlgorithms.Sorting;

/**
 * Created by Денис on 08.05.2016.
 */
public class Shell extends Sorting{

    @Override
    public Comparable[] sort(Comparable[] a) {
        int length = a.length;
        int h = 1;

        while (h < length/3) {
            h = h*3 + 1;
        }

        while (h >= 1) {

            for (int i = h; i < length; i++) {
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
                    exch(a, j ,j - h);
                }
            }

            h /= 3;

        }

        return null;
    }
}
