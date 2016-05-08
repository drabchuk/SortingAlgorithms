import sortingAlgorithms.implementations.*;
import sortingAlgorithms.performance.SortCompare;

public class Main {

    public static void main(String[] args) {

        SortCompare.compareOnRandomArray(new Quick(), new Merge(), 131072);

    }
}
