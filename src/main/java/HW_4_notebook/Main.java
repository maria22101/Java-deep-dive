package HW_4_notebook;

import HW_4_notebook.controller.Controller;
import HW_4_notebook.model.NoteBooksStorage;
import HW_4_notebook.view.View;

public class Main {

    public static void main(String[] args) {
        NoteBooksStorage noteBooksStorage = new NoteBooksStorage();
        View view = new View();

        Controller controller = new Controller(noteBooksStorage, view);

        controller.processUser();
    }
}
