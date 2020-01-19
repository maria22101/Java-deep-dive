package design_patterns.creational_patterns.Singleton;

/**
 * Singleton design pattern implementation ensuring lazy initialization for multi-threading environment
 * Created by Bilous M. 19.01.2020
 */
public class SingletonAppMultiThread {
    public static void main(String[] args) throws InterruptedException {
        final int SIZE = 1000;
        Thread t[] = new Thread[SIZE];
        for (int i = 0; i < SIZE; i++) {
            t[i] = new Thread(new R_Multi());
            t[i].start();
        }
        for (int i = 0; i < SIZE; i++) {
            t[i].join(); // we are waiting until all threads execute their run()
        }
        System.out.println(Singleton.counter);
    }
}

class R_Multi implements Runnable {
    @Override
    public void run() {
        Singleton.getInstance();
    }
}

class Singleton_Multi {
    private static Object sync = new Object();
    public static int counter = 0;
    private static volatile Singleton_Multi instance = null;

    private Singleton_Multi() {
        counter++;
    }

    // double check for null ensures lazy initialization of the Singleton_Multi instance
    public static Singleton_Multi getInstance() {
        if (instance == null) {
            synchronized (sync) {
                if (instance == null) {
                    instance = new Singleton_Multi();
                }
            }

        }
        return instance;
    }
}
