package sortingAlgorithms.generators;

import java.util.Random;

/**
 * Created by Денис on 08.05.2016.
 */
public class RandomGenerator implements RandomGenerated {

    @Override
    public Double[] getRandomArray(int length) {
        Double[] generatedArray = new Double[length];

        Random randomizer = new Random();

        for (int i = 0; i < length; i++) {
            generatedArray[i] = randomizer.nextDouble();
        }

        return generatedArray;
    }
}
