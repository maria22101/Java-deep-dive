package reflection;

import java.lang.reflect.Constructor;
import java.util.Arrays;

/**
 * This class demonstrates getting a class' constructors and its parameters
 */
public class ReflectionConstructor {

    private static final class Cat {
        public String name = "Murzik";
        private int age = 7;
        short earsLength = 5;
        protected long tailLength = 30;

        public Cat() {
        }

        public Cat(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public Cat(String name, int age, short earsLength, long tailLength) {
            this.name = name;
            this.age = age;
            this.earsLength = earsLength;
            this.tailLength = tailLength;
        }
    }

    public static void main(String[] args) {
        Class<?> catClass = Cat.class;

        Constructor<?>[] constructors = catClass.getConstructors();

        System.out.println("----Constructors:---- ");

        Arrays.stream(constructors).forEach(constructor -> {
            System.out.print("Constructor with parameters: ");
            Class<?>[] paramTypes = constructor.getParameterTypes();
            Arrays.stream(paramTypes).forEach(param -> System.out.print(param.getName() + " "));
            System.out.println();
        });
    }


}
