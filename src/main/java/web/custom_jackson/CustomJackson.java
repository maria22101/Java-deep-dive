package web.custom_jackson;

import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

import lombok.Data;
import lombok.SneakyThrows;

/**
 * {@link CustomJackson} provides plain json conversion to the object.
 * The object's fields must be of {@link java.lang.String} type
 */
public class CustomJackson {

    @Data
    public static class Message {
        String text;
        String author;
        String source;
    }

    public static void main(String[] args) {
        String jsonString = "{\n" +
                                "\"text\": \"the new film is coming soon\", \n" +
                                "\"author\": \"mari\", \n" +
                                "\"source\": \"vanityF\"\n" +
                            "}";
        Message message = jsonToObject(jsonString, Message.class);
        System.out.println(message);
    }

    public static <T> T jsonToObject(String jsonString, Class<T> targetClass) {
        Map<String, String> propertiesMap = parseJson(jsonString);
        T instance = createInstance(targetClass);
        setInstanceProperties(targetClass, instance, propertiesMap);
        return instance;
    }

    private static Map<String, String> parseJson(String jsonString) {
        String[] keyValueWithDoubleDot = jsonString
                .replaceAll("[\\{\\}\\n\"]", "")
                .split(",");
        return Arrays.stream(keyValueWithDoubleDot)
                .collect(Collectors.toMap(
                        keyValuePair -> keyValuePair.substring(0, keyValuePair.indexOf(":")).trim(),
                        keyValuePair -> keyValuePair.substring(keyValuePair.indexOf(":") + 1).trim()));
    }

    @SneakyThrows
    private static <T> T createInstance(Class<T> targetClass) {
        Constructor<T> constructor = targetClass.getConstructor();
        return (T) constructor.newInstance();
    }

    private static <T> void setInstanceProperties(Class<T> targetClass, T instance,
                                                  Map<String, String> propertiesMap) {
        Arrays.asList(targetClass.getDeclaredFields())
                .forEach(field -> {
                    field.setAccessible(true);
                    try {
                        field.set(instance, propertiesMap.get(field.getName()));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                });
    }
}
