package HW_3_java_game.version_1;

import java.util.Arrays;

public class Model {
    private final static int INITIAL_SIZE = 5;
    private final static double RESIZE_KOEF = 1.4;
    private int[] resultsHistory;
    private int elementsInResultsHistory = 0;

    public Model() {
        resultsHistory = new int[INITIAL_SIZE];
    }

    public int[] getResultsHistory() {
        return resultsHistory;
    }

    public int getElementsInResultsHistory() {
        return elementsInResultsHistory;
    }

    void updateResultHistory(int number) {
        resize();
        resultsHistory[elementsInResultsHistory++] = number;
    }

    void resize() {
        if (elementsInResultsHistory == resultsHistory.length - 1) {
            int newSize = (int) (resultsHistory.length * RESIZE_KOEF);
            int[] resizedResultHistory = new int[newSize];

            for (int i = 0; i < resultsHistory.length; i++) {
                resizedResultHistory[i] = resultsHistory[i];
            }
            resultsHistory = resizedResultHistory;
        }
    }

    String getResultsHistoryInString() {
            for (int i = 0; i < resultsHistory.length; i++) {
                if (resultsHistory[i] != 0) {
                    return Arrays.toString(resultsHistory);
                }
            }
        return "Terrific! You guessed from the first time!";
    }
}
