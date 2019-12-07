package HW_4_notebook.version_1;

import HW_4_notebook.version_1.controller.Controller;
import HW_4_notebook.version_1.model.NoteBooksStorage;
import HW_4_notebook.version_1.view.View;

public class Main {

    public static void main(String[] args) {
        NoteBooksStorage noteBooksStorage = new NoteBooksStorage();
        View view = new View();

        Controller controller = new Controller(noteBooksStorage, view);

        controller.processUser();
    }

}
