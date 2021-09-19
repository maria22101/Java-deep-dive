package concurrency.basics;

public class MyCustomThreadWithThread extends Thread {

    public MyCustomThreadWithThread(String name) {
        super(name);
    }

    public void run() {
        System.out.printf("I will be doing some stuff in thread %s during  seconds \n", Thread.currentThread().getName());

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Thread has been interrupted");
        }

        System.out.printf("I completed my stuff in thread %s \n", Thread.currentThread().getName());
    }
}
