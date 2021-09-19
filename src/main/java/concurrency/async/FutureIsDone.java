package concurrency.async;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class FutureIsDone {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("Thread main started working");
        ExecutorService executorService = Executors.newFixedThreadPool(1);

        Callable<String> callable = () -> {
            System.out.printf("Thread %s started working\n", Thread.currentThread().getName());
            Thread.sleep(6_000); // time of this async task execution is 5 sec
            return Thread.currentThread().getName();
        };

        Future<String> future = executorService.submit(callable);

        System.out.println("Thread main keeps on working");
        TimeUnit.SECONDS.sleep(3);

        // like we are asking: do we have our async task result?
        while (!future.isDone()) {
            System.out.println("Async task has not been completed yet. Please, wait...");
            TimeUnit.SECONDS.sleep(1);
        }

        System.err.printf("Result from a Future instance: %s\n", future.get());

        executorService.shutdown();
    }
}
