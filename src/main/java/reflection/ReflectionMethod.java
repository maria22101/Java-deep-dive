package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * This class demonstrates ways of a private field change
 * and extended method output - with its name, return types and parameters
 */
public class ReflectionMethod {

    private static final class Cat {
        public String name = "Murzik";
        private int age = 7;
        short earsLength = 5;
        protected long tailLength = 30;

        public Cat() {
        }

        public Cat(int age) {
            this.age = age;
        }

        public Cat(String name, int age, short earsLength, long tailLength) {
            this.name = name;
            this.age = age;
            this.earsLength = earsLength;
            this.tailLength = tailLength;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public long getTailLength() {
            return tailLength;
        }

        public void setTailLength(long tailLength) {
            this.tailLength = tailLength;
        }
    }

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException,
            InstantiationException, IllegalAccessException {

        Class<?> catClass = Cat.class;

        System.out.println("---Private field's value changed using constructor with this field, option1:");
        Class<?>[] paramTypes = new Class<?>[]{int.class};
        Constructor<?> constructor = catClass.getConstructor(paramTypes); // get constructor with parameters of certain type
        Cat cat = (Cat) constructor.newInstance(8); // creating new object using constructor and its parameter
        System.out.println("age field new value: " + cat.getAge()); // 5 -> 8

        System.out.println();

        System.out.println("---Private field's value changed using constructor with this field, option2:");
        Cat kitty = new Cat();
        Method setAgeMethod = catClass.getMethod("setAge", paramTypes); // receiving Method instance by method name and its parameters
        Object[] objArguments = new Object[]{1};
        setAgeMethod.invoke(kitty, objArguments); // setting the new value into the private field
        System.out.println("Age of the kitty: " + kitty.getAge());

        System.out.println();

        System.out.println("---All class' methods output:");
        Method[] methods = catClass.getDeclaredMethods();
        Arrays.stream(methods).forEach(method -> {
            System.out.print("Method-" + method.getName() + ", ");
            System.out.print("ReturnType-" + method.getReturnType().getName() + ", ");
            Class<?>[] paramClasses = method.getParameterTypes();
            System.out.print("param");
            Arrays.stream(paramClasses).forEach(p -> {
                System.out.print("-" + p.getName() + " ");
            });
            System.out.println();
        });
    }
}
