package HW_4_notebook.version_1.model;

import HW_4_notebook.version_1.controller.NoteBook;

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
