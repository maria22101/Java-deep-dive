package HW_3_java_game.version_1;

class View {

    static final String GAME_START = "Welcome! The Game is to guess an integer.";
    static final String FIRST_GUESS = "Have a try: ";
    static final String WRONG_GUESS = "Wrong guess! Proceed considering your progress: ";
    static final String NEXT_GUESS = "Your next try: ";
    static final String INVALID_INPUT = "Wrong input! Repeat please entering an integer: ";
    static final String RESULTS_HISTORY = "Your results history is: ";
    static final String LAST_GUESS = "Your last guess is: ";
    static final String NUMBER_RANGE = "The number to guess is within range: ";
    static final String GAME_FINISH = "Congratulations! You won!";

    void printMessage(String str) {
        System.out.println(str);
    }
}
