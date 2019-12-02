package HW_4_notebook.version_1;

/**
 * Created by Bilous M. 29.11.2019
 */
public class View {
    //text constants
    public static final String START_MESSAGE = "Please enter the following data fields: ";
    public static final String SURNAME = "Surname: ";
    public static final String NAME = "Name: ";
    public static final String FATHER_NAME = "Father name: ";
    public static final String NICK_NAME = "Nickname: ";
    public static final String COMMENT = "Comment: ";
    public static final String GROUPS = "Groups: ";
    public static final String HOME_PHONE = "Home phone: ";
    public static final String CELL_PHONE_1 = "Cell phone main: ";
    public static final String CELL_PHONE_2 = "Cell phone additional: ";
    public static final String E_MAIL = "E-mail: ";
    public static final String SKYPE = "Skype: ";
    public static final String ADDRESS = "Address (in format: \"Postal code\", \"City\"" +
            ", \"Street\", \"House number\", \"Appartment number\"";
    public static final String DATE_OF_NOTE_CREATION = "Date of the note creation: ";
    public static final String DATE_OF_NOTE_LAST_MODIFICATION = "Date of the note last modification: ";

    //Utilities methods
    public void printMessage(String str) {
        System.out.println(str);
    }

    public String concatenatedString(String... message) {
        StringBuilder concatString = new StringBuilder();
        for (String s : message) {
            concatString.append(s);
        }
        return new String(concatString);
    }
}
