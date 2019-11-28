package HW_3_java_game.version_2_refactored;

import java.util.Scanner;

/**
 * Created by Bilous M. 25.11.2019
 */
public class Controller {
    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    //The Work method
    public void processUser() {
        Scanner sc = new Scanner(System.in);
        model.setPrimaryBarrier(GlobalConstants.PRIMARY_MIN_BARRIER, GlobalConstants.PRIMARY_MAX_BARRIER);
        model.setSecretValue();

        while (model.checkInput(getInputValueWithScanner(sc)));

        view.printMessage(view.GAME_FINISH + model.getSecretValue());
        view.printMessage(view.YOUR_WAY + model.getInputsHistoryInString());
    }

    private int getInputValueWithScanner(Scanner sc) {
        int input = 0;
        view.printMessage(model.getElementsInInputsHistory() > 0 ? getWrongInputMessage() : getWelcomeMessage());

        while (true) {
            while (!sc.hasNextInt()) {
                view.printMessage(getWrongInputMessage());
                sc.next();
            }
            if ((input = sc.nextInt()) <= model.getMinBarrier() || input >= model.getMaxBarrier()) {
                view.printMessage(getWrongInputMessage());
                continue;
            }
            break;
        }

        return input;
    }

    private String getInputIntMessage() {
        return view.concatenatedString(
                view.INPUT_INT_DATA,
                view.OPEN_SQUARE_BRACKET,
                String.valueOf(model.getMinBarrier()),
                view.SPACE_SIGN,
                String.valueOf(model.getMaxBarrier()),
                view.CLOSE_SQUARE_BRACKET,
                view.SPACE_SIGN,
                view.EQUAL_SIGN,
                view.SPACE_SIGN);
    }

    private String getWelcomeMessage() {
        return view.concatenatedString(
                view.GAME_START,
                getInputIntMessage());
    }

    private String getWrongInputMessage() {
        return view.concatenatedString(
                view.WRONG_INPUT_INT_DATA,
                view.YOUR_WAY,
                model.getInputsHistoryInString(),
                view.FULL_STOP_SIGN,
                getInputIntMessage());
    }
}
