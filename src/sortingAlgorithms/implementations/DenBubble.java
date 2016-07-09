package sortingAlgorithms.implementations;

import sortingAlgorithms.Sorting;

/**
 * Created by Денис on 09.07.2016.
 */
public class DenBubble extends Sorting {

    @Override
    public Comparable[] sort(Comparable[] a) {
        int right = a.length - 1;
        int left = 0;

        while (right >= left) {
            for (int i = left; i < right; i++) {
                if (less(a[i + 1], a[i])) {
                    exch(a, i, i + 1);
                }
            }
            right--;
            for (int i = right; i > left; i--) {
                if (less(a[i], a[i - 1])) {
                    exch(a, i, i - 1);
                }
            }
            left++;
        }

        return a;
    }
}
