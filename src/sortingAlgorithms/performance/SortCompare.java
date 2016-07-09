package sortingAlgorithms.performance;

import sortingAlgorithms.Sorting;
import sortingAlgorithms.generators.RandomGenerated;
import sortingAlgorithms.generators.RandomGenerator;

import java.util.Timer;

/**
 * Created by Денис on 08.05.2016.
 */
public class SortCompare {

    public static long time(Sorting sortAlgImplementation, Comparable[] data) {
        long beginTime = System.currentTimeMillis();

        sortAlgImplementation.sort(data);

        long endTime = System.currentTimeMillis();

        return (endTime - beginTime);
    }

    public static boolean compareOnRandomArray(Sorting sortAlg1, Sorting sortAlg2, int length) {
        RandomGenerated generator = new RandomGenerator();
        Comparable[] data = generator.getRandomArray(length);
        Comparable[] dataCopy = data.clone();

        long time1 = time(sortAlg1, data);
        long time2 = time(sortAlg2, dataCopy);
        long fasterTime, slowerTime;

        double index = (double) time1/time2;

        double reducedIndex;
        String fasterAlgName, slowerAlgName;

        if (index < 1) {
            fasterAlgName = sortAlg1.getClass().getSimpleName();
            slowerAlgName = sortAlg2.getClass().getSimpleName();
            fasterTime = time1;
            slowerTime = time2;
            reducedIndex = 1. / index;
        } else {
            fasterAlgName = sortAlg2.getClass().getSimpleName();
            slowerAlgName = sortAlg1.getClass().getSimpleName();
            fasterTime = time2;
            slowerTime = time1;
            reducedIndex = index;
        }

        System.out.println("Time performance test.");
        System.out.println("Array length: " + length);
        System.out.println(fasterAlgName + " sort time = " + fasterTime + "ms");
        System.out.println(slowerAlgName + " sort time = " + slowerTime + "ms");
        System.out.println(fasterAlgName +
                " sort is " + reducedIndex + " times faster than " +
                slowerAlgName + " sort.");

        return (time1 < time2);
    }

}
