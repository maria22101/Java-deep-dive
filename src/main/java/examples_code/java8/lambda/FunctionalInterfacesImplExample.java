package examples_code.java8.lambda;

import java.math.BigDecimal;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.BooleanSupplier;
import java.util.function.Consumer;
import java.util.function.DoubleBinaryOperator;
import java.util.function.DoubleConsumer;
import java.util.function.DoubleFunction;
import java.util.function.DoublePredicate;
import java.util.function.DoubleSupplier;
import java.util.function.DoubleToIntFunction;
import java.util.function.DoubleToLongFunction;
import java.util.function.DoubleUnaryOperator;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import java.util.function.IntPredicate;
import java.util.function.IntSupplier;
import java.util.function.IntToDoubleFunction;
import java.util.function.IntToLongFunction;
import java.util.function.IntUnaryOperator;
import java.util.function.LongBinaryOperator;
import java.util.function.LongConsumer;
import java.util.function.LongPredicate;
import java.util.function.LongSupplier;
import java.util.function.LongToDoubleFunction;
import java.util.function.LongToIntFunction;
import java.util.function.LongUnaryOperator;
import java.util.function.ObjDoubleConsumer;
import java.util.function.ObjIntConsumer;
import java.util.function.ObjLongConsumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.ToDoubleBiFunction;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongBiFunction;
import java.util.function.ToLongFunction;
import java.util.function.UnaryOperator;

public class FunctionalInterfacesImplExample {

    public static void main(String[] args) {
        IntToDoubleFunction intToDouble = num -> (double) num;
        System.out.println("IntToDoubleFunction: " + intToDouble.applyAsDouble(3));

        IntUnaryOperator intUnaryOperator = num -> num * 10;
        System.out.println("IntUnaryOperator: " + intUnaryOperator.applyAsInt(2));

        UnaryOperator<String> unaryOperator = str -> str + "!";
        System.out.println("UnaryOperator: " + unaryOperator.apply("Attention"));

        ToIntFunction<String> toIntFunction = str -> Integer.parseInt(str);
        System.out.println("ToIntFunction: " + toIntFunction.applyAsInt("15"));

        ToLongFunction<Integer> toLongFunction = num -> (long) (num * 1000);
        System.out.println("ToLongFunction: " + toLongFunction.applyAsLong(150));

        ToDoubleBiFunction<Long, Integer> toDoubleBiFunction = (num, pow) -> Math.pow((double) num, (double) pow);
        System.out.println("ToDoubleBiFunction: " + toDoubleBiFunction.applyAsDouble(1222L, 3));

        Function<Integer, String> intToStrFunction = num -> String.valueOf(num);
        System.out.println("Function: " + intToStrFunction.apply(123));

        LongBinaryOperator longBinaryOperator = (x, y) -> Math.abs(x) + Math.abs(y);
        System.out.println("LongBinaryOperator: " + longBinaryOperator.applyAsLong(123L, 456L));

        Supplier<Runnable> supplierOfRunnable = () -> () -> System.out.println("Hello from supplierOfRunnable");
        new Thread(supplierOfRunnable.get(), "threadWithSuppliedRunnable").run();

        DoubleUnaryOperator doubleUnaryOperator = doubleNum -> doubleNum + 123;
        System.out.println("DoubleUnaryOperator: " + doubleUnaryOperator.applyAsDouble(10000));

        ObjLongConsumer<String> objLongConsumer = (str, longNum) -> System.out.println(str + longNum);
        objLongConsumer.accept("Number of users: ", 1000);

        BinaryOperator<String> binaryOperator = (str1, str2) -> (str1 + " " + str2).toUpperCase();
        System.out.println(binaryOperator.apply("Good", "morning"));

        BiFunction<String, Integer, Integer> biFunction = (str, index) -> str.split(" ")[index].length();
        System.out.println(biFunction.apply("Long read", 1));

        LongToDoubleFunction longToDoubleFunction = l -> Math.pow((double) l, 3);
        System.out.println(longToDoubleFunction.applyAsDouble(1890L));

        IntBinaryOperator intBinaryOperator = (x, y) -> Math.abs(x + y);
        System.out.println(intBinaryOperator.applyAsInt(-238, 12));

        IntFunction<String> intFunction = num -> "hello".repeat(num);
        System.out.println(intFunction.apply(3));

        LongConsumer longConsumer = l -> System.out.println(Math.pow((double) l, 2));
        longConsumer.accept(123456L);

        ObjIntConsumer<String> objIntConsumer = (str, num) -> System.out.println(str.repeat(num));
        objIntConsumer.accept("Morning", 4);

        IntConsumer intConsumer = num -> System.out.println(num * 2);
        intConsumer.accept(13);

        LongSupplier longSupplier = () -> ThreadLocalRandom.current().nextLong();
        System.out.println(longSupplier.getAsLong());

        Predicate<String> predicate = str -> str.contains("vo");
        System.out.println(predicate.test("Brav"));

        DoubleConsumer doubleConsumer = doubleNum -> System.out.println(doubleNum);
        doubleConsumer.accept(12.45);

        DoubleSupplier doubleSupplier = () -> ThreadLocalRandom.current().nextDouble();
        System.out.println(doubleSupplier.getAsDouble());

        Consumer<String> consumer = str -> System.out.println(str);
        consumer.accept("Greetings!");

        BiConsumer<String, Integer> biConsumer = (str, count) -> System.out.println(str.repeat(count));
        biConsumer.accept("Hey", 5);

        DoubleToLongFunction doubleToLongFunction = doubleNum -> (long) Math.cos(doubleNum);
        System.out.println(doubleToLongFunction.applyAsLong(123.45));

        DoubleFunction<Integer> doubleFunction = doubleValue -> (int) (doubleValue / 3);
        System.out.println(doubleFunction.apply(123.56));

        BiPredicate<String, Integer> biPredicate = (str, maxAllowed) -> str.length() <= maxAllowed;
        System.out.println(biPredicate.test("PriorityA", 5));

        DoublePredicate doublePredicate = doubleValue -> Math.pow(doubleValue, 2) < 1_000_000;
        System.out.println(doublePredicate.test(12345));

        IntPredicate intPredicate = intValue -> intValue > 0;
        System.out.println(intPredicate.test(222));

        LongToIntFunction longToIntFunction = longValue -> Math.toIntExact(longValue);
        System.out.println(longToIntFunction.applyAsInt(123456L));

        DoubleToIntFunction doubleToIntFunction = doubleValue -> (int) doubleValue;
        System.out.println(doubleToIntFunction.applyAsInt(123.56));

        IntToLongFunction intToLongFunction = intValue -> Math.floorDiv(12345L, intValue);
        System.out.println(intToLongFunction.applyAsLong(22));

        LongPredicate longPredicate = longValue -> Long.valueOf(longValue).toString().length() < 10;
        System.out.println(longPredicate.test(123456L));

        BooleanSupplier booleanSupplier = () -> ThreadLocalRandom.current().nextInt() > 10;
        System.out.println(booleanSupplier.getAsBoolean());

        IntSupplier intSupplier = () -> ThreadLocalRandom.current().nextInt();
        System.out.println(intSupplier.getAsInt());

        ToDoubleFunction<BigDecimal> toDoubleFunction = bigDecimalValue -> bigDecimalValue.doubleValue();
        System.out.println(toDoubleFunction.applyAsDouble(BigDecimal.valueOf(123.45)));

        DoubleBinaryOperator doubleBinaryOperator = (num1, num2) -> Math.min(num1, num2);
        System.out.println(doubleBinaryOperator.applyAsDouble(123.45, 567.89));

        ToLongBiFunction<Integer, Integer> toLongBiFunction = (num1, num2) -> num1 * num2;
        System.out.println(toLongBiFunction.applyAsLong(123, 456));

        LongUnaryOperator longUnaryOperator = longValue -> Math.abs(longValue);
        System.out.println(longUnaryOperator.applyAsLong(123456L));

        ObjDoubleConsumer<String> objDoubleConsumer =
                (str, doubleValue) -> System.out.println(str + " " + doubleValue);
        objDoubleConsumer.accept("temperature today: ", 36.6);
    }
}
