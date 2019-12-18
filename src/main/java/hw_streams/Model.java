package hw_streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * This class demonstrates some Stream API functionality
 * Created by Bilous M. 18.12.2019
 */
public class Model {
    private int length;
    private int minBarrier;
    private int maxBarrier;
    private int number;
    private int[] initialArray;

    // Setting the variables
    public void setVariables(int length, int minBarrier, int maxBarrier, int number) {
        this.length = length;
        this.minBarrier = minBarrier;
        this.maxBarrier = maxBarrier;
        this.number = number;
        initialArray = getRandomArray();
    }

    public int[] getRandomArray() {
        int[] result = new int[length];
        for (int i = 0; i < result.length; i++) {
            result[i] = minBarrier + (int) (Math.random() * (maxBarrier - minBarrier + 1));
        }
        return result;
    }

    public double averageValueOption1(int[] arr) {
        return Arrays.stream(arr)
                .average()
                .getAsDouble();
    }

    public double averageValueOption2(int[] arr) {
        double sum = Arrays.stream(arr).sum();
        double count = Arrays.stream(arr).count();
        return sum / count;
    }

    public double averageValueOption3(int[] arr) {
        return Arrays.stream(arr)
                .boxed()
                .collect(Collectors.averagingInt(Integer::intValue));
    }

    public Map.Entry<Integer, Integer> minValueElementWithIndex(int[] arr) {
        AtomicInteger a = new AtomicInteger();
        return Arrays.stream(arr)
                .boxed()
                .collect(Collectors.toMap(n -> a.getAndIncrement(), m -> m))
                .entrySet()
                .stream()
                .min(Comparator.comparingInt(Map.Entry::getValue))
                .get();
    }

    public long numberOfZeroElements(int[] arr) {
        return Arrays.stream(arr)
                .filter(x -> x == 0)
                .count();
    }

    public long numberOfAboveZeroElements(int[] arr) {
        return Arrays.stream(arr)
                .filter(x -> x > 0)
                .count();
    }

    public int[] multipliedByNumberArray(int[] arr) {
        return Arrays.stream(arr)
                .map(x -> x * number)
                .toArray();
    }

    public int[] getInitialArray() {
        return initialArray;
    }
}
