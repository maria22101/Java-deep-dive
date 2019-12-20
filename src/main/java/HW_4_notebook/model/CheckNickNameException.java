package HW_4_notebook.model;

import HW_4_notebook.controller.NoteBook;

public class CheckNickNameException extends Exception {
    private NoteBook noteBook;

    public CheckNickNameException(NoteBook noteBook) {
        this.noteBook = noteBook;
    }

    @Override
    public String toString() {
        return "NickName " + noteBook.getNickName() + " already occupied. Repeat your entry using different nickName";
    }
}
