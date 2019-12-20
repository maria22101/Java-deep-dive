package HW_4_notebook.controller;

import HW_4_notebook.view.View;

import java.util.Scanner;

import static HW_4_notebook.controller.RegexContainer.*;
import static HW_4_notebook.view.TextConstant.*;

/**
 * Created by Bilous M. 05.12.2019
 */
public class NoteBook {
    private View view;
    private Scanner sc;

    private String firstName;
    private String lastName;
    private String fatherName;
    private String fullName;
    private String nickName;
    private String comment;
    private String hobbyGroups;
    private String homePhone;
    private String cellPhone1;
    private String cellPhone2;
    private String eMail;
    private String skype;
    private String zipCode;
    private String city;
    private String street;
    private String houseNumber;
    private String appartmentNumber;
    private String address;
    private String dateOfNoteCreation;
    private String dateOfNoteLastModification;

    public NoteBook(View view, Scanner sc) {
        this.view = view;
        this.sc = sc;
    }

    public void inputNote() {
        UtilityController utilityController = new UtilityController(sc, view);

        String regexStr = (String.valueOf(View.bundle.getLocale()).equals("ua")
                ? REGEX_FIRST_NAME_UKR : REGEX_FIRST_NAME_ENG);
        this.firstName = utilityController.inputStringValueWithScanner(FIRST_NAME, regexStr);

        regexStr = (String.valueOf(View.bundle.getLocale()).equals("ua")
                ? REGEX_LAST_NAME_UKR : REGEX_LAST_NAME_ENG);
        this.lastName = utilityController.inputStringValueWithScanner(LAST_NAME, regexStr);

        regexStr = (String.valueOf(View.bundle.getLocale()).equals("ua")
                ? REGEX_FATHER_NAME_UKR : REGEX_FATHER_NAME_ENG);

        this.fatherName = utilityController
                .inputStringValueWithScanner(FATHER_NAME, regexStr);

        this.nickName = utilityController
                .inputStringValueWithScanner(NICK_NAME, REGEX_NICK_NAME);

        this.comment = utilityController
                .inputStringValueWithScanner(COMMENT, REGEX_COMMENT);

        this.hobbyGroups = utilityController
                .inputStringValueWithScanner(GROUPS, REGEX_GROUPS);

        this.homePhone = utilityController
                .inputStringValueWithScanner(HOME_PHONE, REGEX_HOME_PHONE);

        this.cellPhone1 = utilityController
                .inputStringValueWithScanner(CELL_PHONE_1, REGEX_CELL_PHONE1);

        this.cellPhone2 = utilityController
                .inputStringValueWithScanner(CELL_PHONE_2, REGEX_CELL_PHONE2);

        this.eMail = utilityController
                .inputStringValueWithScanner(E_MAIL, REGEX_EMAIL);

        this.skype = utilityController
                .inputStringValueWithScanner(SKYPE, REGEX_SKYPE);

        regexStr = (String.valueOf(View.bundle.getLocale()).equals("ua")
                ? REGEX_ZIPCODE_UKR : REGEX_ZIPCODE_ENG);
        this.zipCode = utilityController
                .inputStringValueWithScanner(ZIP_CODE, regexStr);

        regexStr = (String.valueOf(View.bundle.getLocale()).equals("ua")
                ? REGEX_CITY_UKR : REGEX_CITY_ENG);
        this.city = utilityController.
                inputStringValueWithScanner(CITY, regexStr);

        regexStr = (String.valueOf(View.bundle.getLocale()).equals("ua")
                ? REGEX_STREET_UKR : REGEX_STREET_ENG);
        this.street = utilityController.
                inputStringValueWithScanner(STREET, regexStr);

        regexStr = (String.valueOf(View.bundle.getLocale()).equals("ua")
                ? REGEX_HOUSE_NUMBER_UKR : REGEX_HOUSE_NUMBER_ENG);

        this.houseNumber = utilityController
                .inputStringValueWithScanner(HOUSE_NUMBER, regexStr);

        this.appartmentNumber = utilityController
                .inputStringValueWithScanner(APPARTMENT_NUMBER, REGEX_APPARTMENT_NUMBER);

        this.dateOfNoteCreation = utilityController
                .inputStringValueWithScanner(DATE_OF_NOTE_CREATION, REGEX_DATE_OF_NOTE_CREATION);

        this.dateOfNoteLastModification = utilityController
                .inputStringValueWithScanner(DATE_OF_NOTE_LAST_MODIFICATION, REGEX_DATE_OF_NOTE_LAST_MODIFICATION);

        this.fullName = view.concatenatedString(lastName, " ",
                String.valueOf(firstName.charAt(0)), ".");

        this.address = view.concatenatedString(zipCode, " ", city, ", ",
                street, " ", houseNumber, ", " , appartmentNumber);
    }

    public String getNickName() {
        return nickName;
    }
}
