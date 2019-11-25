package HW_3_java_game.version_1;

public class View {

    public static final String GAME_START = "Welcome! The Game is to guess an integer.";
    public static final String FIRST_GUESS = "Have a try: ";
    public static final String WRONG_GUESS = "Wrong guess! Proceed considering your progress: ";
    public static final String NEXT_GUESS = "Your next try: ";
    public static final String INVALID_INPUT = "Wrong input! Repeat please entering an integer: ";
    public static final String RESULTS_HISTORY = "Your results history is: ";
    public static final String LAST_GUESS = "Your last guess is: ";
    public static final String NUMBER_RANGE = "The number to guess is within range: ";
    public static final String GAME_FINISH = "Congratulations! You won!";

    void printMessage(String str) {
        System.out.println(str);
    }
}
