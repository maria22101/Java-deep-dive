package web.jackson;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonDatabindDemo {

    public static void parseJsonAndPrint(String path) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Person person = objectMapper.readValue(new File(path), Person.class);
        System.out.println(person);
    }

    public static void main(String[] args) throws IOException {
        parseJsonAndPrint("src/main/resources/person.json");
    }
}
