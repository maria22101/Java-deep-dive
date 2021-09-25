package concurrency.basics;

public class ThreadDemo1 {

    public static void main(String[] args) {
        System.out.println("Thread main started working");

        // starting thread composed with use of instance of class that implements Runnable interface:
        MyCustomThreadWithRunnable withRunnable = new MyCustomThreadWithRunnable();
        new Thread(withRunnable, "MyCustomThreadWithRunnable").start();

        // starting thread using instance of class that extends Thread
        new MyCustomThreadWithThread("MyCustomThreadWithThread").start();

        System.out.println("Thread main finished working");
    }
}
