package reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Class finds the nested class fields' modifiers
 */
public class Modifiers {

    private static final class Cat {
        public String name = "Murzik";
        private int age = 7;
        short earsLength = 5;
        protected long tailLength = 30;
    }

    public static void main(String[] args) {
        Class<?> catClass = Cat.class;

        Field[] fields = catClass.getDeclaredFields();

        Map<String, String> fieldModifierMap = new HashMap<>();

        Arrays.stream(fields).forEach(field -> {
            String fieldName = field.getName();
            String fieldModifier = defineModifier(field.getModifiers());
            fieldModifierMap.put(fieldName, fieldModifier);
        });

        fieldModifierMap.forEach((key, value) -> {
            System.out.print(key + "-" + value);
            System.out.println();
        });
    }

    static String defineModifier(int modifier) {
        String modifierStr = "no modifier";
        if(Modifier.isPublic(modifier)) {
            modifierStr = "public";
        }
        if(Modifier.isPrivate(modifier)) {
            modifierStr = "private";
        }
        if(Modifier.isProtected(modifier)) {
            modifierStr = "protected";
        }
        return modifierStr;
    }
}
