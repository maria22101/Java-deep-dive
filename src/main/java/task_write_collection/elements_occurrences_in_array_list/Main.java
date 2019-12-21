package task_write_collection.elements_occurrences_in_array_list;

/**
 * Created by Bilous M. 20.12.2019
 */
public class Main {
    public static void main(String[] args) {
        Model model = new Model();
        View view = new View();
        Controller controller = new Controller(model, view);

        controller.processUser();
    }
}
