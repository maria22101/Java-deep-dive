package HW_4_notebook.version_1;

import java.util.ArrayList;
import java.util.List;

public class Model {
    private List<Note> noteBook;

    public Model() {
        noteBook = new ArrayList<Note>();
    }

    class Note {
        private String name;
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

        public void setName(String name) {
            this.name = name;
        }

        public void setSurName(String surName) {
            this.surName = surName;
        }

        public void setFatherName(String fatherName) {
            this.fatherName = fatherName;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
        }

        public void setComment(String comment) {
            this.comment = comment;
        }

        public void setHobbyGroups(List<HobbyGroups> hobbyGroups) {
            this.hobbyGroups = hobbyGroups;
        }

        public void setHomePhone(String homePhone) {
            this.homePhone = homePhone;
        }

        public void setCellPhone1(String cellPhone1) {
            this.cellPhone1 = cellPhone1;
        }

        public void setCellPhone2(String cellPhone2) {
            this.cellPhone2 = cellPhone2;
        }

        public void seteMail(String eMail) {
            this.eMail = eMail;
        }

        public void setSkype(String skype) {
            Skype = skype;
        }

        public void setZipCode(String zipCode) {
            this.zipCode = zipCode;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public void setStreet(String street) {
            this.street = street;
        }

        public void setHouseNumber(String houseNumber) {
            this.houseNumber = houseNumber;
        }

        public void setAppartmentNumber(String appartmentNumber) {
            this.appartmentNumber = appartmentNumber;
        }

        public void setDateOfNoteCreation(String dateOfNoteCreation) {
            this.dateOfNoteCreation = dateOfNoteCreation;
        }

        public void setDateOfNoteLastModification(String dateOfNoteLastModification) {
            this.dateOfNoteLastModification = dateOfNoteLastModification;
        }
    }
}
