package HW_3_java_game.version_2_refactored;

public class View {
    //text constants
    public final static String EQUAL_SIGN = "=";
    public final static String SPACE_SIGN = " ";
    public final static String OPEN_SQUARE_BRACKET = "]";
    public final static String CLOSE_SQUARE_BRACKET = "[";
    public final static String INPUT_INT_DATA = "Input INT value: ";
    public final static String WRONG_INPUT_INT_DATA = "Wrong input! Repeat please! ";
    public static final String GAME_FINISH = "Congratulations! You have won! Secret value = ";
    public static final String YOUR_WAY = "Your way = ";

    public static final String GAME_START = "Welcome! The Game is to guess an integer.";
    //    public static final String FIRST_GUESS = "Have a try: ";
//    public static final String WRONG_GUESS = "Wrong guess! Proceed considering your progress: ";
//    public static final String NEXT_GUESS = "Your next try: ";
    public static final String INVALID_INPUT = "Wrong input! Repeat please entering an integer: ";
    public static final String RESULTS_HISTORY = "Your results history is: ";
    public static final String LAST_GUESS = "Your last guess is: ";
    public static final String NUMBER_RANGE = "The number to guess is within range: ";

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
