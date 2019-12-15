package hw_lombok_test;

public class App {
    public static void main(String[] args) {
        Student student = Student.builder()
                .name("Evan")
                .build();
        student.setGroup("FM-72");
        System.out.println(student);
    }
}
