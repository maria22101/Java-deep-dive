package concurrency.basics;

public class MonitorSample {

    public static void main(String[] args) {
        Runnable runnable = () -> {
            System.out.printf("Thread %s starts working\n", Thread.currentThread().getName());
            System.out.printf("Thread %s trying to get access to synchronized method\n", Thread.currentThread().getName());
            synchronizedMethod ();
            System.out.printf("Thread %s finished work\n", Thread.currentThread().getName());
        };

        Thread thread1 = new Thread(runnable, "Thread1");
        Thread thread2 = new Thread(runnable, "Thread2");
        thread1.start();
        thread2.start();
    }

    private synchronized static void synchronizedMethod() {
        try {
            System.out.printf("Thread %s entered synchronized method\n", Thread.currentThread().getName());
            Thread.sleep(5000);
            System.out.printf("Thread %s is working with synchronized method\n", Thread.currentThread().getName());
            Thread.sleep(5000);
            System.out.printf("Thread %s finishes working with synchronized method\n", Thread.currentThread().getName());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
