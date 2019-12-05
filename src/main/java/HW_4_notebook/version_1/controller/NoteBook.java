package HW_4_notebook.version_1.controller;

import HW_4_notebook.version_1.HobbyGroups;
import HW_4_notebook.version_1.view.TextConstant;
import HW_4_notebook.version_1.view.View;

import java.util.List;
import java.util.Scanner;

import static HW_4_notebook.version_1.controller.RegexContainer.*;

/**
 * Created by Bilous M. 05.12.2019
 */
public class NoteBook {
    private View view;
    private Scanner sc;

    private String firstName;
    private String surName;
    private String fatherName;
    private String fullName;
    private String nickName;
    private String comment;
    private List<HobbyGroups> hobbyGroups;
    private String homePhone;
    private String cellPhone1;
    private String cellPhone2;
    private String eMail;
    private String Skype;
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
        String regexStr = (String.valueOf(View.bundle.getLocale().equals("ua")
                ? REGEX_FIRST_NAME_UKR : REGEX_FIRST_NAME_ENG));
        this.firstName = utilityController.inputStringValueWithScanner(TextConstant.FIRST_NAME, regexStr);
    }
}
