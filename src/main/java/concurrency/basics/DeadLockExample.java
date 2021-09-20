package concurrency.basics;

public class DeadLockExample {

    public static void main(String[] args) throws InterruptedException {

        Stats stats1 = new Stats();
        Stats stats2 = new Stats();

        Thread stats11 = new Thread(() -> {
            synchronized (stats1) { // meaning stats1 object is captured
                try {
                    Thread.sleep(1000);
                    stats2.incrementCounter();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread stats12 = new Thread(() -> {
            synchronized (stats2) { // meaning stats2 object is captured
                stats1.incrementCounter();
            }
        });

        stats11.start(); // stats11 thread captured stats1's monitor and tries to call stats2, but stats2 is captured
        stats12.start(); // stats12 thread captured stats2's monitor and tries to call stats1, but stats1 is captured

        Thread statePrinter = new Thread(() -> {
            while (true) {
                System.out.println(stats11.getState());
                System.out.println(stats12.getState());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        statePrinter.start(); // both threads' state became BLOCKED
    }
}
