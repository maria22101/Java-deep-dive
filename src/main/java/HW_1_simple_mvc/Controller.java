package HW_1_simple_mvc;

import java.util.Scanner;

public class Controller {
    // The Constants
    public static final String STRING_1 = "hello";
    public static final String STRING_2 = "java";

    // Constructor
    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model  = model;
        this.view = view;
    }

    // The Work method
    public void processUser(){
        Scanner sc = new Scanner(System.in);

        model.setString1(inputStringWithScanner(sc, STRING_1));
        model.setString2(inputStringWithScanner(sc, STRING_2));

        view.printWelcomeMessage(model.getString1(), model.getString2());
    }

    // The Utility methods
    public String inputStringWithScanner(Scanner sc, String stringToValidate) {
        view.printMessage(View.INPUT_STRING);
        String inputString = sc.next();

        while( ! inputString.equals(stringToValidate)) {
            view.printMessage(View.WRONG_INPUT_STRING_DATA);
            inputString = sc.next();
        }
        return inputString;
    }
}
