package hw_streams;

import static hw_streams.GlobalConstants.*;
import static hw_streams.TextConstants.*;

/**
 * Created by Bilous M. 18.12.2019
 */
public class Controller {
    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void processUser() {
        model.setVariables(ARRAY_LENGTH,
                            ARRAY_ELEMENTS_MIN_BARRIER,
                            ARRAY_ELEMENTS_MAX_BARRIER,
                            NUMBER_FOR_ARRAY_ELEMENTS_MULTIPLICATION);

        view.printMessage(view.concatenatedString(
                INITIAL_ARRAY,
                view.arrayInString(model.getInitialArray())));

        view.printMessage(view.concatenatedString(
                AVERAGE_OF_ARRAY_ELEMENTS_OPTION_1,
                String.valueOf(model.averageValueOption1(model.getInitialArray()))));

        view.printMessage(view.concatenatedString(
                AVERAGE_OF_ARRAY_ELEMENTS_OPTION_2,
                String.valueOf(model.averageValueOption2(model.getInitialArray()))));

        view.printMessage(view.concatenatedString(
                AVERAGE_OF_ARRAY_ELEMENTS_OPTION_3,
                String.valueOf(model.averageValueOption3(model.getInitialArray()))));

        view.printMessage(view.concatenatedString(
                MIN_VALUE_ELEMENT_AND_ITS_INDEX,
                String.valueOf(model.minValueElementWithIndex(model.getInitialArray()))));

        view.printMessage(view.concatenatedString(
                ZERO_ELEMENTS_NUMBER,
                String.valueOf(model.numberOfZeroElements(model.getInitialArray()))));

        view.printMessage(view.concatenatedString(
                ABOVE_ZERO_ELEMENTS_NUMBER,
                String.valueOf(model.numberOfAboveZeroElements(model.getInitialArray()))));

        view.printMessage(view.concatenatedString(
                ARRAYS_ELEMENTS_TO_BE_MULTIPLIED,
                String.valueOf(NUMBER_FOR_ARRAY_ELEMENTS_MULTIPLICATION),
                COLON_SIGN,
                view.arrayInString(model.multipliedByNumberArray(model.getInitialArray()))));
    }
}
