package HW_4_notebook.version_1.controller;

import HW_4_notebook.version_1.model.CheckNickNameException;
import HW_4_notebook.version_1.model.NoteBooksStorage;
import HW_4_notebook.version_1.view.View;

import java.util.Scanner;

/**
 * Created by Bilous M. 29.11.2019
 */
public class Controller {
    private NoteBooksStorage noteBooksStorage;
    private View view;

    public Controller(NoteBooksStorage noteBooksStorage, View view) {
        this.noteBooksStorage = noteBooksStorage;
        this.view = view;
    }

    public void processUser() {
        Scanner sc = new Scanner(System.in);
        NoteBook noteBook = new NoteBook(view, sc);
        noteBook.inputNote();

        while (true) {
            try {
                noteBooksStorage.add(noteBook);
                break;
            } catch (CheckNickNameException e) {
                view.printMessage(e.toString());
            }
            noteBook.inputNote();
        }
    }
}
