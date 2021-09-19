package concurrency.basics;

import java.util.concurrent.Semaphore;

public class SemaphoreSample {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(2);// semaphore counter = 2 means that this semaphore will allow working with the subsequent resource for 2 thread
        Runnable runnable = () -> {
            try {
                System.out.printf("Thread %s submits access request to methodNotForAllThreads.\n",
                        Thread.currentThread().getName());
                semaphore.acquire(); // semaphore's counter decreased by 1 for one allowing Thread; when counter = 0, no threads will get access to the method
                methodNotForAllThreads();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            semaphore.release(); // semaphore's counter will be incremented by 1, signalling the method access release for 1 Thread
        };

        Thread thread1 = new Thread(runnable, "Thread_1");
        Thread thread2 = new Thread(runnable, "Thread_2");
        Thread thread3 = new Thread(runnable, "Thread_3");
        thread1.start();
        thread2.start();
        thread3.start();
    }

    private static void methodNotForAllThreads() {
        try {
            System.out.printf("Thread %s entered methodNodForAllThreads\n", Thread.currentThread().getName());
            Thread.sleep(10_000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
