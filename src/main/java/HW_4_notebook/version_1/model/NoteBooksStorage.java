package HW_4_notebook.version_1.model;

import HW_4_notebook.version_1.controller.NoteBook;

import java.util.ArrayList;
import java.util.List;

public class NoteBooksStorage {
    private List<NoteBook> noteBooks;

    public NoteBooksStorage() {
        noteBooks = new ArrayList<>();
    }

    public void add(NoteBook nb) {
        noteBooks.add(nb);
    }

    public List<NoteBook> getNoteBooks() {
        return noteBooks;
    }
}
