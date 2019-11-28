package HW_3_java_game.version_2_refactored;

/**
 * Created by Bilous M. 25.11.2019
 */
public class View {
    //text constants
    public final static String EQUAL_SIGN = "=";
    public final static String SPACE_SIGN = " ";
    public final static String FULL_STOP_SIGN = ". ";
    public final static String OPEN_SQUARE_BRACKET = "]";
    public final static String CLOSE_SQUARE_BRACKET = "[";
    public final static String INPUT_INT_DATA = "Input INT value: ";
    public final static String WRONG_INPUT_INT_DATA = "Wrong input! Repeat please! ";
    public static final String GAME_START = "Welcome! The GAME is to guess the number from the stated ]range[. ";
    public static final String GAME_FINISH = "Congratulations! You have won! Secret value = ";
    public static final String YOUR_WAY = "Your way: ";

    //Utilities methods
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
}
