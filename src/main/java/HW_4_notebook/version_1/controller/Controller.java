package HW_4_notebook.version_1.controller;

import HW_4_notebook.version_1.model.Model;
import HW_4_notebook.version_1.view.View;

import java.util.Scanner;

/**
 * Created by Bilous M. 29.11.2019
 */
public class Controller {
    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void processUser() {
        Scanner sc = new Scanner(System.in);
        NoteBook noteBook = new NoteBook(view, sc);
        noteBook.inputNote();
    }
}
