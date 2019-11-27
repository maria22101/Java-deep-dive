package HW_3_java_game.version_1;

import java.util.Arrays;
import java.util.Scanner;

public class Controller {
    static final int DEFAULT_MIN = 0;
    static final int RAND_MAX = (int) (Math.random() * 101);

    private Model model;
    private View view;

    Controller(Model m, View v) {
        model = m;
        view = v;
    }

    // The Work method
    void processUser() {

        /*
        * if you want an int from the particular lowerBound and upperBound:
        * 1) introduce the two int variables: lowerBound and upperBound respectively;
        * 2) use rand(int from, int to) method instead of rand();
        * 3) initialize int[] updatedRange = {lowerBound, upperBound};
         */
        int number = rand();
        int[] updatedRange = {0, 100};
        view.printMessage(View.GAME_START);
        view.printMessage(View.NUMBER_RANGE + Arrays.toString(updatedRange));
        view.printMessage(View.FIRST_GUESS);
        Scanner sc = new Scanner(System.in);
        int userAnswer = getUserAnswer(sc);

        while (userAnswer != number) {
            model.updateResultHistory(userAnswer);
            view.printMessage(View.WRONG_GUESS);
            view.printMessage(View.RESULTS_HISTORY + model.getResultsHistoryInString());
            view.printMessage(View.LAST_GUESS + model.getResultsHistory()[model.getElementsInResultsHistory() - 1]);

            if (userAnswer < number) {
                updatedRange[0] = userAnswer;
            }
            if (userAnswer > number) {
                updatedRange[1] = userAnswer;
            }

            view.printMessage(View.NUMBER_RANGE + Arrays.toString(updatedRange));
            view.printMessage(View.NEXT_GUESS);
            userAnswer = getUserAnswer(sc);
        }

        view.printMessage(View.GAME_FINISH);
        if (model.getElementsInResultsHistory() > 0) {
            model.updateResultHistory(userAnswer);
            view.printMessage(View.RESULTS_HISTORY + model.getResultsHistoryInString());
            view.printMessage(View.LAST_GUESS + model.getResultsHistory()[model.getElementsInResultsHistory() - 1]);
        }
    }

    // The Utility methods
    int rand() {
        return DEFAULT_MIN + (int) (Math.random() * (RAND_MAX + 1 - DEFAULT_MIN));
    }

    public int rand(int from, int to) {
        return from + (int) (Math.random() * (to + 1 - from));
    }

    int getUserAnswer(Scanner sc) {
        while (!sc.hasNextInt()) {
            view.printMessage(View.INVALID_INPUT);
            sc.next();
        }
        return sc.nextInt();
    }

}
