package examples_code.class_members;

public class Base {
    int x = 10;

    public Base() {
        System.out.println("Base constructor");
        show();
    }

    void show() {
        System.out.println("Base show " + x + " ");
    }
}
