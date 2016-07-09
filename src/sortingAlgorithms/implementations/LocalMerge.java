package sortingAlgorithms.implementations;

import sortingAlgorithms.Sorting;

/**
 * Created by Денис on 18.05.2016.
 */
public class LocalMerge extends Sorting {

    @Override
    public Comparable[] sort(Comparable[] a) {
        int length = a.length;
        int[] localMaximums = new int[length / 3];
        int localMaxHead = 0;
        int localMin = 0;
        boolean isIncreased = true;
        Comparable[] aux = new Comparable[a.length];

        for (int i = 1; i < length; i++) {
            if (less(a[i], a[i + 1])) {
                if (!isIncreased) {
                    isIncreased = true;
                    mergeMount(a, aux, localMin, localMaxHead, i);
                    localMin = i + 1;
                    //sort previous
                }
            } else {
                if (isIncreased) {
                    localMaximums[localMaxHead] = i;
                    localMaxHead++;
                    isIncreased = false;
                }
            }
        }

        mergeMountOfSortedArrays(a, aux, 0, 1, 3, 5, localMaximums);
        return a;
    }

    private void sidesMerge(Comparable[] a, Comparable[] aux, int[] localMaximums) {

    }

    private void mergeMount(Comparable[] a, Comparable[] aux, int from, int max, int to) {
        int right = max + 1;
        int left = max - 1;
        int counter = from;
        aux[counter] = a[max];
        counter++;
        while (right <= to && left >= from) {
            if (less(a[left], a[right])) {
                aux[counter++] = a[right++];
            } else {
                aux[counter++] = a[left--];
            }
        }
        while (counter <= to) {
            aux[counter++] = a[right++];
        }
        while (left >= from) {
            aux[counter--] = a[left--];
        }
        System.arraycopy(aux, from, a, from, to - from);
    }

    private void mergeMountOfSortedArrays(
            Comparable[] a, Comparable[] aux,
            int noteBegin,
            int from, int max, int to,
            int[] localMaximums
    ) {
        int right = max + 1;
        int left = max - 1;
        int counter = noteBegin;
        int[] localMaximumsNew = new int[localMaximums.length];
        System.arraycopy(localMaximums, 0, localMaximumsNew, 0, localMaximums.length);
        int maxNeigh;
        while (true) {
            //Select max neighbour
            int nearestLeft;
            int nearestRight;
            if (max == from) {
                nearestRight = 1;
                nearestLeft = 0;
            } else if (max == to) {
                nearestRight = 0;
                nearestLeft = -1;
            } else {
                nearestLeft = -1;
                nearestRight = 1;
            }
            nearestLeft = -1;
            nearestRight = 0;
            while ( max + nearestLeft - 1 >= from
                    && !(localMaximumsNew[max + nearestLeft] > localMaximums[max + nearestLeft - 1])
                    ) {
                nearestLeft--;
            }
            if (!(localMaximumsNew[max + nearestLeft] > localMaximums[max + nearestLeft - 1])) {
                if (!(localMaximumsNew[from] > noteBegin)) {
                    nearestLeft = 0;
                } else {
                    nearestLeft--;
                }
            }

            //move right
            while ( max + nearestRight + 1 <= localMaximums[to]
                    && !(localMaximumsNew[max + nearestRight] > localMaximums[max + nearestRight - 1])
                    ) {
                nearestRight++;
            }
            if (!(localMaximumsNew[max + nearestRight] > localMaximums[max + nearestRight - 1])) {
                if (!(localMaximumsNew[to] > localMaximums[to - 1])) {
                    nearestRight = 0;
                } else {
                    nearestRight++;
                }
            }
            if (nearestLeft == 0 && nearestRight == 0) {
                break;
            }

            if (less(a[localMaximumsNew[max + nearestLeft]], a[localMaximumsNew[max + nearestRight]])) {
                maxNeigh = right;
            } else {
                maxNeigh = left;
            }

            //Cut the top of mountain
            while (!less(a[localMaximumsNew[max]], a[localMaximumsNew[maxNeigh]])
                    && max != from
                    && localMaximumsNew[max] > localMaximums[max - 1]) {
                aux[counter++] = a[localMaximumsNew[max]];
                localMaximumsNew[max]--;
            }
            //Change the top of mountain
            max = maxNeigh;
        }


        /*while (true) {
            if (less(a[left], a[right])) {
                aux[counter++] = a[right++];
            } else {
                aux[counter++] = a[left--];
            }
        }
        while (right <= to) {
            aux[counter++] = a[right++];
        }
        while (left >= noteBegin) {
            aux[counter--] = a[left--];
        }*/
    }

}
