/*
* Sorting.java
* version 1.0
* 08.05.2016
*
* This class is a superclass to all various of
* sorting algorithm implementation
* */

package sortingAlgorithms;

/**
 * Created by Denis Drabchuck on 08.05.2016.
 */
public class Sorting implements Sortable{

    @Override
    public void sort(Comparable[] a) {}

    protected static boolean less(Comparable v, Comparable w) {
        return (v.compareTo(w) < 0);
    }

    protected static void exch(Comparable[] a, int i, int j) {
        Comparable tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void show(Comparable[] a) {
        for (Comparable element: a) {
            System.out.println(element);
        }
    }

    public static boolean isSorted(Comparable[] a) {
        int length = a.length;
        for (int i = 1; i < length; i++) {
            if (less(a[i], a[i - 1])) {
                return false;
            }
        }
        return true;
    }

}