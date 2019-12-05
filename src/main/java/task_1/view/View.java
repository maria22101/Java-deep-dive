package task_1.view;

import java.util.Locale;
import java.util.ResourceBundle;

public class View {
    static String REQUEST_BUNDLE_NAME = "request";
    public static final ResourceBundle bundle =
            ResourceBundle.getBundle(
                    REQUEST_BUNDLE_NAME,
                    new Locale("ua", "UA")); // Ukrainian
//                    new Locale("en")); // English

    public void printMessage(String message){
        System.out.println(message);
    }

    public void printSign(String sign) {
        System.out.print(sign);
    }

    public void printRequest(String request) {
        printMessage(bundle.getString(request));
    }
}
