package examples_code.class_members;

public class Child2 extends Base {
    int x = 20;

    public Child2() {
        System.out.println("Child constructor");
        show();
    }

    void show() {
        System.out.println("Child show " + x + " ");
    }

    public static void main(String[] args) {
        new Child2();
        // 1) Base constructor
        // 2) Child show 0 - default value as Child2's x have not been initialized yet
        // 3) Child constructor
        // 4) Child show 20
    }
}
