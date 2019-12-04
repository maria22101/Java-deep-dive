package task_1;

import task_1.controller.Controller;
import task_1.model.Utility;
import task_1.view.View;

public class Main {
    public static void main(String[] args) {
        Utility utility = new Utility();
        View view = new View();

        Controller controller = new Controller(utility, view);

    }
}
