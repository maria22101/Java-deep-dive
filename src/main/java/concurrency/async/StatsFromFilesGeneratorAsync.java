package concurrency.async;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import concurrency.async.utils.FileUtils;

public class StatsFromFilesGeneratorAsync {
    public static void main(String[] args) {

        Callable<Void> callable1 = () -> {
            FileUtils.getStatistic("src/main/resources/file1.csv", "src/main/resources/result1.csv");
            return null;
        };
        Callable<Void> callable2 = () -> {
            FileUtils.getStatistic("src/main/resources/file2.csv", "src/main/resources/result2.csv");
            return null;
        };
        Callable<Void> callable3 = () -> {
            FileUtils.getStatistic("src/main/resources/file3.csv", "src/main/resources/result3.csv");
            return null;
        };

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        long start = System.currentTimeMillis();
        executorService.submit(callable1);
        executorService.submit(callable2);
        executorService.submit(callable3);
        executorService.shutdown();

        System.out.println("Time required to generate statistics: " +
                (System.currentTimeMillis() - start));

        // Time required to generate statistics in async execution is 1 ms (8 times less in comparison with consequent execution)
    }
}
