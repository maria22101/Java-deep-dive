package reflection;

import java.lang.reflect.Member;
import java.util.Arrays;

/**
 * This class demonstrates getting Class' public fields, constructors and methods
 */
public class ClassPublicMembersRetriever {

    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> c = String.class;
        System.out.println(c);

        printMembers(c.getFields()); //public fields of String class

        printMembers(c.getConstructors()); //public constructors of String class

        printMembers(c.getMethods()); //public methods of String class
    }

    static void printMembers(Member[] members) {
        Arrays.stream(members)
                .filter(member -> member.getDeclaringClass() != Object.class) // in order to exclude methods of Object class
                .map(Object::toString)
                .forEach(System.out::println);
    }
}
