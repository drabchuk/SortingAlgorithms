import sortingAlgorithms.*;
import sortingAlgorithms.generators.*;
import sortingAlgorithms.implementations.*;

/**
 * Created by Денис on 08.05.2016.
 */
public class MainSort {

    public static void main(String[] args) {

        //Comparable[] data = RandomGenerated.Array1.clone();
        Comparable[] data = new Comparable[RandomGenerated.Array1.length];
        System.arraycopy(RandomGenerated.Array1, 0, data, 0, RandomGenerated.Array1.length);

        Sorting sorter = new DenBubble();

        Comparable[] sorted = sorter.sort(data);

        assert sorter.isSorted(data);

        sorter.show(sorted);

    }

}
