package concurrency.async;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableAndFutureSample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("Thread main started working");
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        Callable<String> callable = () -> {
            System.out.printf("Thread %s started working\n", Thread.currentThread().getName());
            Thread.sleep(3000);
            return Thread.currentThread().getName();
        };

        List<Future<String>> futures = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            futures.add(executorService.submit(callable));
        }

        System.out.println("Thread main keeps on working");

        for (Future<String> future : futures) {
            System.err.printf("Result from a Future instance: %s\n", future.get());
        }

        executorService.shutdown();
    }
}
