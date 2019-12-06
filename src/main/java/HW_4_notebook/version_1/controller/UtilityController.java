package HW_4_notebook.version_1.controller;

import HW_4_notebook.version_1.view.View;

import java.util.Scanner;

/**
 * Created by Bilous M. 05.12.2019
 */
public class UtilityController {
    private Scanner scanner;
    private View view;

    public UtilityController(Scanner scanner, View view) {
        this.scanner = scanner;
        this.view = view;
    }

    String inputStringValueWithScanner(String message, String regex) {
        String result;
        view.printStringInput(message);
        while (!(scanner.hasNext() &&
                (result = scanner.nextLine()).matches(regex))) {
            view.printWrongStringInput(message);
        }
        return result;
    }
}
