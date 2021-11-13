package reflection;

import java.lang.reflect.Field;
import java.util.Arrays;

/**
 * This class demonstrates getting a class' fields
 */
public class ReflectionField {

    private static final class Cat {
        public String name = "Murzik";
        private int age = 7;
        short earsLength = 5;
        protected long tailLength = 30;
    }

    public static void main(String[] args) {
        Class<?> catClass = Cat.class; // getting object of class that is type for Cat class

        System.out.println("----Public fields: ");
        Field[] publicFields = catClass.getFields(); // getting fields with public access
        Arrays.stream(publicFields).forEach(field -> {
            Class<?> fieldClass = field.getType();
            System.out.print("Field name: " + field.getName() + "; ");
            System.out.println("Field class: " + fieldClass.getName());
        });

        System.out.println();
        System.out.println("----All fields: ");
        Field[] allFields = catClass.getDeclaredFields(); // getting all fields regardless the access
        Arrays.stream(allFields).forEach(field -> {
            Class<?> fieldClass = field.getType();
            System.out.print("Field name: " + field.getName() + "; ");
            System.out.println("Field class: " + fieldClass.getName());
        });


    }
}
