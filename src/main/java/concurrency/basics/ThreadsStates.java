package concurrency.basics;

public class ThreadsStates {

    public static void main(String[] args) throws InterruptedException {
        final String RESOURCE = "resource";
        Runnable runnable = () -> {
            synchronized (RESOURCE) {
                try {
                    Thread.sleep(4000);
                    RESOURCE.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Runnable notifier = () -> {
            synchronized (RESOURCE) {
                RESOURCE.notifyAll();
            }
        };
        Thread thread1 = new Thread(runnable, "thread1");
        Thread thread2 = new Thread(runnable, "thread2");
        Thread notifyingThread = new Thread(notifier);

        System.out.println(thread1.getName() + ": " + thread1.getState()); // NEW
        thread1.start();
        System.out.println(thread1.getName() + ": " + thread1.getState()); // RUNNING
        Thread.sleep(1000);
        System.out.println(thread1.getName() + ": " + thread1.getState()); // TIME_WAITING
        thread2.start();
        Thread.sleep(1000);
        System.out.println(thread2.getName() + ": " + thread2.getState()); // BLOCKED
        Thread.sleep(3000);
        System.out.println(thread1.getName() + ": " + thread1.getState()); // WAITING
        notifyingThread.start();
        Thread.sleep(5000);
        System.out.println(thread1.getName() + ": " + thread1.getState()); // TERMINATED
    }
}
