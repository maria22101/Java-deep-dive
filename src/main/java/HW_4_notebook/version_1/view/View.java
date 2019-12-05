package HW_4_notebook.version_1.view;

import java.util.Locale;
import java.util.ResourceBundle;

import static HW_4_notebook.version_1.view.TextConstant.INPUT_STRING_DATA;
import static HW_4_notebook.version_1.view.TextConstant.WRONG_INPUT_DATA;


/**
 * Created by Bilous M. 29.11.2019
 */
public class View {

    // Resource Bundle installation
    static String MESSAGES_BUNDLE_NAME = "messages";
    public static final ResourceBundle bundle =
            ResourceBundle.getBundle(
                    MESSAGES_BUNDLE_NAME,
//                    new Locale("ua", "UA")); // Ukrainian
                    new Locale("en")); // English

    // Utilities methods
    public void printMessage(String str) {
        System.out.println(str);
    }

    public String concatenatedString(String... message) {
        StringBuilder concatString = new StringBuilder();
        for (String s : message) {
            concatString.append(s);
        }
        return new String(concatString);
    }

    public void printStringInput(String message) {
        printMessage(concatenatedString(
                bundle.getString(INPUT_STRING_DATA),
                bundle.getString(message)));
    }

    public void printWrongStringInput(String message) {
        printMessage(concatenatedString(
                bundle.getString(WRONG_INPUT_DATA),
                bundle.getString(INPUT_STRING_DATA),
                bundle.getString(message)));
    }
}
