package HW_4_notebook.controller;

public interface RegexContainer {
    String REGEX_FIRST_NAME_UKR = "^[А-ЩЬЮЯҐІЇЄ][а-щьюяґіїє']{1,20}$";
    String REGEX_FIRST_NAME_ENG = "^[A-Z][a-z]{1,20}$";

    String REGEX_LAST_NAME_UKR = "^[А-ЩЬЮЯҐІЇЄ][а-щьюяґіїє']{1,20}$";
    String REGEX_LAST_NAME_ENG = "^[A-Z][a-z]{1,20}$";

    String REGEX_FATHER_NAME_UKR = "^[А-ЩЬЮЯҐІЇЄ][а-щьюяґіїє']{1,20}$";
    String REGEX_FATHER_NAME_ENG = "^[A-Z][a-z]{1,20}$";

    String REGEX_NICK_NAME = "[A-Za-z0-9]+";
    String REGEX_COMMENT = ".{0,100}";
    String REGEX_GROUPS = "(((FITNESS)|(COOKING)|(READING)|(MUSIC)|(DANCING))[(, ) ]*){1,5}";
    String REGEX_HOME_PHONE = "^\\+\\d{3}[- ]?\\d{2,3}[- ]?\\d{3}[- ]?\\d{2}[- ]?\\d{2}$";
    String REGEX_CELL_PHONE1 = "^\\+\\d{3}[- ]?\\d{2,3}[- ]?\\d{3}[- ]?\\d{2}[- ]?\\d{2}$";
    String REGEX_CELL_PHONE2 = "^\\+\\d{3}[- ]?\\d{2,3}[- ]?\\d{3}[- ]?\\d{2}[- ]?\\d{2}$";
    String REGEX_EMAIL = "^[-\\w.]+@([A-z0-9][-A-z0-9]+\\.)+[A-z]{2,4}$";
    String REGEX_SKYPE = "^[a-z][-_a-z0-9]{5,31}$";

    String REGEX_ZIPCODE_UKR = "\\d{5}";
    String REGEX_ZIPCODE_ENG = "[A-Z]{2}\\d[A-Z] \\d[A-Z]{2}"; // Zip code format in Great Britain

    String REGEX_CITY_UKR = "^[А-ЩЬЮЯҐІЇЄ][-А-ЩЬЮЯҐІЇЄа-щьюяґіїє' ]{1,30}$";
    String REGEX_CITY_ENG = "^[A-Z][-A-Za-z ]{1,30}$";

    String REGEX_STREET_UKR = "^[А-ЩЬЮЯҐІЇЄ][-А-ЩЬЮЯҐІЇЄа-щьюяґіїє' ]{1,40}$";
    String REGEX_STREET_ENG = "^[A-Z][-A-Za-z ]{1,40}$";

    String REGEX_HOUSE_NUMBER_UKR = "^\\d{1,5}([-А-ЩЬЮЯҐІЇЄа-щьюяґіїє'/0-9]{1,10})?$";
    String REGEX_HOUSE_NUMBER_ENG = "^\\d{1,5}([-A-Za-z'/0-9]{1,10})?$";

    String REGEX_APPARTMENT_NUMBER = "\\d{1,5}";
    String REGEX_DATE_OF_NOTE_CREATION = "^(0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.](19|20)\\d\\d$";
    String REGEX_DATE_OF_NOTE_LAST_MODIFICATION = "^(0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.](19|20)\\d\\d$";
}
