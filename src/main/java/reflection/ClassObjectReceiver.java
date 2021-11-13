package reflection;

import java.util.Map;

/**
 * This class demonstrates ways of getting Class object
 */
public class ClassObjectReceiver {

    public static void main(String[] args) throws ClassNotFoundException {
        var classReceiving = new ClassObjectReceiver();
        int[] arr = new int[10];

        // 1. using a class instance and getClass() method
        Class<?> aClass = classReceiving.getClass();        //class reflection.ClassObjectReceiver
        Class<?> bClass = "hello".getClass();               //class java.lang.String
        Class<?> cClass = arr.getClass();                   //class [I
        Class<?> dClass = Integer.valueOf(8).getClass();    //class java.lang.Integer

        // 2. using the class name and .class property
        Class<?> eClass = ClassObjectReceiver.class;        //class reflection.ClassObjectReceiver
        Class<?> gClass = String.class;                     //class java.lang.String
        Class<?> fClass = int[].class;                      //class [I
        Class<?> hClass = Integer.class;                    //class java.lang.Integer

        // 3. Class.forName(), full path to be submitted as a parameter
        Class<?> jClass = Class.forName("reflection.ClassObjectReceiver"); //class reflection.ClassObjectReceiver
        Class<?> kClass = Class.forName("java.lang.String");               //class java.lang.String
        Class<?> lClass = Class.forName("[I"); // responsible for int[]    //class [I
        Class<?> mClass = Class.forName("java.lang.Integer");              //class java.lang.Integer

        // 4. via reflection classes/interfaces within inheritance/interface implementation
        Class<?> nClass = Integer.class.getSuperclass(); //class java.lang.Number
        Class<?> oClass = Map.Entry.class.getEnclosingClass(); //interface java.util.Map
    }
}
