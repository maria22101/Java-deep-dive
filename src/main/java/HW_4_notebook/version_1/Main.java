package HW_4_notebook.version_1;

import HW_4_notebook.version_1.controller.Controller;
import HW_4_notebook.version_1.model.Model;
import HW_4_notebook.version_1.view.View;

public class Main {

    public static void main(String[] args) {
        Model model = new Model();
        View view = new View();
        Controller controller = new Controller(model, view);

        controller.processUser();
    }

}
