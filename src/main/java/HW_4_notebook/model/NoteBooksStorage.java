package HW_4_notebook.model;

import HW_4_notebook.controller.NoteBook;

import java.util.ArrayList;
import java.util.List;

public class NoteBooksStorage {
    private List<NoteBook> noteBooks;

    public NoteBooksStorage() {
        noteBooks = new ArrayList<>();
    }

    public void add(NoteBook nb) throws CheckNickNameException {
        if (noteBooks.isEmpty()) {
            noteBooks.add(nb);
        } else {
            for (NoteBook noteBook : noteBooks) {
                if (noteBook.getNickName().equals(nb.getNickName())) {
                    throw new CheckNickNameException(noteBook);
                }
            }
            noteBooks.add(nb);
        }
    }

    public List<NoteBook> getNoteBooks() {
        return noteBooks;
    }
}
