package concurrency.cafe;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class CafeMain {
    static final Semaphore tables = new Semaphore(2); // assumes the cafe has two tables
    static final Semaphore waiter = new Semaphore(1); // assumes the cafe has one waiter

    static boolean isOpenHours = true;

    public synchronized static boolean isOpen() {
        return isOpenHours;
    }

    public synchronized static void isClosed() {
        isOpenHours = false;
    }

    public static void main(String[] args) throws InterruptedException {
        Runnable runnableCafe = () -> {
            int i = 0;
            while (isOpen()) {
                try {
                    new Thread(new CafeVisitors(), String.valueOf(i)).start();
                    i++;
                    TimeUnit.SECONDS.sleep(1); // every 1 second visitors come in
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread cafeThread = new Thread(runnableCafe, "Cafe");
        cafeThread.start();
        TimeUnit.SECONDS.sleep(4); // cafe is working during 4 seconds :), quite short-working-hours-cafe :)
        isClosed();
    }
}
