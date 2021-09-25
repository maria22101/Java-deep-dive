package concurrency.fork_join;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;

public class ForkJoinDemo1 {
    public static int THRESHOLD;

    public static void main(String[] args) {
        int[] numbers = initNumbers(100_000_000);
        int numberOfProcessors = Runtime.getRuntime().availableProcessors();
        System.out.println("Number of processors: " + numberOfProcessors);
        THRESHOLD = numbers.length / numberOfProcessors;

        // how much time finding max number using simple iteration takes
        long start = System.currentTimeMillis();
        System.out.println("Max number: " + findMaxWithSimpleIteration(numbers, numbers.length));
        System.out.println("Time for finding max number using simple iteration: " +
                (System.currentTimeMillis() - start) + " ms\n"); // ~39 ms

        ForkJoinPool pool = new ForkJoinPool(numberOfProcessors);
        MaxFindingForkJoinTask task = new MaxFindingForkJoinTask(numbers, 0, numbers.length);

        start = System.currentTimeMillis();
        System.out.println("Max number: " + findMaxWithSimpleIteration(numbers, numbers.length));
        System.out.println("Time for finding max number using ForkJoin: " +
                (System.currentTimeMillis() - start) + " ms"); // ~34 ms

    }

    private static int[] initNumbers(int arraySize) {
        Random random = new Random();
        int[] numbers = new int[arraySize];
        for (int i = 0; i < arraySize; i++) {
            numbers[i] = random.nextInt(1_000_000_000);
        }
        return numbers;
    }

    public static int findMaxWithSimpleIteration(int[] numbers, int highIndex) {
        int max = numbers[0];
        for (int i = 0; i < highIndex; i++) {
            if(numbers[i] > max) {
                max = numbers[i];
            }
        }
        return max;
    }
}
