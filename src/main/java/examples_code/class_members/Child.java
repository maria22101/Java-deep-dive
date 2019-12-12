package examples_code.class_members;

public class Child extends Base {

    public Child() {
        System.out.println("Child constructor");
        show();
    }

    void show() {
        System.out.println("Child show " + x + " ");
    }

    public static void main(String[] args) {
        new Child();
        // 1) Base constructor
        // 2) Child show 10
        // 3) Child constructor
        // 4) Child show 10
    }
}
