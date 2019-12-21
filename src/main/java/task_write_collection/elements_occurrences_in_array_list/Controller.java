package task_write_collection.elements_occurrences_in_array_list;

import static task_write_collection.elements_occurrences_in_array_list.GlobalConstants.*;
import static task_write_collection.elements_occurrences_in_array_list.TextConstants.*;

/**
 * Created by Bilous M. 20.12.2019
 */
public class Controller {
    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void processUser() {
        Model model = new Model(ARRAY_LIST_ELEMENTS_MIN_BARRIER,
                                ARRAY_LIST_ELEMENTS_MAX_BARRIER,
                                ARRAY_LIST_CAPACITY);

        view.printMessage(view.concatenatedString(
                INITIAL_ARRAY_LIST,
                model.getList().toString()));

        view.printMessage(ARRAY_LIST_ELEMENTS_WITH_OCCURRENCES);
        view.displayMap(model
                .getNumberOfElementsOccurrences(model.getList()));
    }
}
