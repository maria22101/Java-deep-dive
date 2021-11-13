package reflection;

import java.lang.reflect.Field;

/**
 * This class demonstrates setting up a class' private field value
 */
public class PrivateFieldValueSetup {

    private static class Dog {
        private int age = 3;
    }

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Dog dog = new Dog();

        Class<?> dogClass = Dog.class;
        Field field = dogClass.getDeclaredField("age"); // getting the Field named "age"
        field.setAccessible(true); // setting the field modifier to the most accessible (public)
        int age = field.getInt(dog); // getting the current value of the field
        field.setInt(dog, 5); // setting the new value
        int updatedAge = field.getInt(dog);

        System.out.println("Initial age: " + age);
        System.out.println("Updated age: " + updatedAge);
    }
}
