package examples_code.java8.lambda;

import java.util.List;

public class Human {
    String name;
    List<String> pets;

    public Human(String name, List<String> pets) {
        this.name = name;
        this.pets = pets;
    }

    public String getName() {
        return name;
    }

    public List<String> getPets() {
        return pets;
    }
}
