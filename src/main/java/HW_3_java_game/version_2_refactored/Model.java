package HW_3_java_game.version_2_refactored;

public class Model {
    private final static int INITIAL_INPUTS_HISTORY_SIZE = 4;
    private final static double INPUTS_HISTORY_RESIZE_KOEF = 1.3;

    private int minBarrier;
    private int maxBarrier;
    private int secretValue;

    private int[] inputsHistory;
    private int elementsInInputsHistory;

    public Model() {
        inputsHistory = new int[INITIAL_INPUTS_HISTORY_SIZE];
    }

    public int getMinBarrier() {
        return minBarrier;
    }

    public int getMaxBarrier() {
        return maxBarrier;
    }

    public int getSecretValue() {
        return secretValue;
    }

    public void setSecretValue() {
        secretValue = minBarrier + (int) (Math.random() * (maxBarrier + 1 - minBarrier));;
    }

    public int[] getInputsHistory() {
        return inputsHistory;
    }

    public int getElementsInInputsHistory() {
        return elementsInInputsHistory;
    }

    public void setPrimaryBarrier(int minBarrier, int maxBarrier) {
        this.minBarrier = minBarrier;
        this.maxBarrier = maxBarrier;
    }

    void updateInputsHistory(int input) {
        resize();
        inputsHistory[elementsInInputsHistory++] = input;
    }

    public String inputsHistoryInString() {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < elementsInInputsHistory; i++) {
            sb.append(inputsHistory[i] + " ");
        }
        return sb.toString();
    }

    public void resize() {
        if (elementsInInputsHistory == inputsHistory.length - 1) {
            int newSize = (int) (inputsHistory.length * INPUTS_HISTORY_RESIZE_KOEF);
            int[] resizedResultHistory = new int[newSize];

            for (int i = 0; i < inputsHistory.length; i++) {
                resizedResultHistory[i] = inputsHistory[i];
            }
            inputsHistory = resizedResultHistory;
        }
    }

    public boolean checkInput(int input) {
        updateInputsHistory(input);
        if (input == secretValue) {
            return false;
        } else if (input > secretValue) {
            maxBarrier = input;
        } else {
            minBarrier = input;
        }
        return true;
    }
}
