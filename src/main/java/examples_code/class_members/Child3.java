package examples_code.class_members;

public class Child3 extends Base {
    int x = 50;

    public static void main(String[] args) {
        Child3 child3 = new Child3();
        System.out.println(child3.x); // 50 - of child

        Base base = child3;
        System.out.println(base.x); // 10 - of parent

        new Child3().show(); // 10 - of parent
    }
}
