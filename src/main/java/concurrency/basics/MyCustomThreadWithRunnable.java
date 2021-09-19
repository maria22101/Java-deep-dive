package concurrency.basics;

public class MyCustomThreadWithRunnable implements Runnable {

    @Override
    public void run() {
        System.out.printf("I will be doing some stuff in thread %s during 3 seconds \n", Thread.currentThread().getName());

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println("Thread has been interrupted");
        }

        System.out.printf("I completed my stuff in thread %s \n", Thread.currentThread().getName());
    }
}
