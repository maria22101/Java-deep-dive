package examples_code.java8.lambda;

import java.util.function.*;

public class LambdaEx1 {

    public static void main(String[] args) {

        // Runnable functional interface example with anonymous class, lambda, method reference
        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Anonymous class example");
            }
        };
        runnable1.run();
        Runnable runnable2 = () -> System.out.println("Lambda example");
        runnable2.run();
        Runnable runnable3 = LambdaEx1::run;

        // Function functional interface example with anonymous class and lambda
        Function functional1 = new Function() {
            @Override
            public Object apply(Object o) {
                return o.toString();
            }
        };
        System.out.println(functional1.apply(44));
        Function functional2 = f -> f.toString();
        System.out.println(functional2.apply(55));

        // Predicate functional interface example
        Predicate predicate = p -> (int) p % 2 == 0;
        System.out.println(predicate.test(7));

        // BiFunction functional interface example
        BiFunction biFunction = (a, b) -> (int) a + (int) b;
        System.out.println(biFunction.apply(4, 8));

        // Supplier functional interface example
        Supplier supplier = () -> "Example of Supplier functional interface";
        System.out.println(supplier.get());

        // Consumer functional interface example
        Consumer consumer = c -> System.out.println(c.toString() + " is returned using Consumer interface");
        consumer.accept("PURSUE");
    }

    private static void run() {
        System.out.println("Lambda example");
    }
}
