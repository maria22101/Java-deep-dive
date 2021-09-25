package concurrency.basics;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;

public class HelloOutputDifferentTools {

    public static void main(String[] args) {
        // 1. output from a new instance of Thread
        Runnable runnable = () -> System.out.println("Hello from Runnable");
        new Thread(runnable).start();

        // 2. output by ExecutorService
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        executorService.submit(() -> System.out.println("Hello from Executor"));
        executorService.shutdown();

        // 3. output by ForkJoin
        ForkJoinPool.commonPool().invoke(new PrintTask());

        // 4. output by CompletableFuture
        CompletableFuture.runAsync(() -> System.out.println("Hello from completable future"));
    }
}
