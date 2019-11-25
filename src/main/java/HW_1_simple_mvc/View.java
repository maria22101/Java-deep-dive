package HW_1_simple_mvc;

public class View {
    // Text's constants
    public static final String INPUT_STRING = "Input string = ";
    public static final String WRONG_INPUT_STRING_DATA = "Wrong input! Repeat please! ";

    public void printMessage(String message){
        System.out.println(message);
    }

    public void printWelcomeMessage(String string1, String string2){
        System.out.println(string1 + " " + string2);
    }
}
