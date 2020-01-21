package design_patterns.creational_patterns;

/**
 * Singleton design pattern implementation ensuring lazy initialization
 * Created by Bilous M. 19.01.2020
 */

public class SingletonApp {
    public static void main(String[] args) throws InterruptedException {
        final int SIZE = 1000;
        Singleton t[] = new Singleton[SIZE];
        for (int i = 0; i < SIZE; i++) {
            t[i] = Singleton.getInstance();
        }
        System.out.println(Singleton.counter); // 1 will be returned
    }
}

class Singleton {
    public static int counter = 0;
    private static Singleton instance;

    private Singleton() {
        counter++;
    }

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

}
