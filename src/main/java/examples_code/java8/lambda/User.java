package examples_code.java8.lambda;

public class User {
    private String name;
    private String surname;
    private int age;
    private int friendsNum;

    public User(String name, String surname, int age, int friendsNum) {
        this(name, age);
        this.surname = surname;
        this.friendsNum = friendsNum;
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getSurname() {
        return surname;
    }

    public int getFriendsNum() {
        return friendsNum;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", friendsNum=" + friendsNum +
                '}';
    }
}
