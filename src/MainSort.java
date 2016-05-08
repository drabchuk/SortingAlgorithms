import sortingAlgorithms.*;
import sortingAlgorithms.generators.*;
import sortingAlgorithms.implementations.*;

/**
 * Created by Денис on 08.05.2016.
 */
public class MainSort {

    public static void main(String[] args) {

        Comparable[] data = RandomGenerated.Array1.clone();

        Sorting sorter = new Quick();

        sorter.sort(data);

        assert sorter.isSorted(data);

        sorter.show(data);

    }

}
