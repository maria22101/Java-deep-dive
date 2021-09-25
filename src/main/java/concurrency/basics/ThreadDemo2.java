package concurrency.basics;

public class ThreadDemo2 {

    public static void main(String[] args) {
        Runnable runnable = () -> {
            System.out.printf("I will be doing some stuff in thread %s during 2 seconds \n",
                    Thread.currentThread().getName());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println("Thread has been interrupted");
            }
            System.out.printf("I completed my stuff in thread %s \n",
                    Thread.currentThread().getName());
        };

        // starting thread using the above implementation of Runnable:
        Thread thread = new Thread(runnable, "ThreadWithRunnableLambda");
        thread.start();
    }

}
