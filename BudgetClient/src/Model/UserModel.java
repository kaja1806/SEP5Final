package Model;

import javafx.scene.control.ComboBox;

import javax.swing.*;
import java.io.Serializable;
import java.util.List;

public class UserModel {

    public static class RegistrationModel implements Serializable {
        public String FirstName;
        public String LastName;
        public String Email;
        public String Address;
        public NameOfBanks NameOfBank;
        public String PhoneNr;
        public String Password;
        public String PasswordConfirmation;

        public RegistrationModel(String firstName, String lastName, String email, String address, String phoneNr, String password, String passwordConfirmation) {
            FirstName = firstName;
            LastName = lastName;
            Email = email;
            Address = address;
            PhoneNr = phoneNr;
            Password = password;
            PasswordConfirmation = passwordConfirmation;
        }

        public String getFirstName() {
            return FirstName;
        }

        public String getLastName() {
            return LastName;
        }

        public String getEmail() {
            return Email;
        }

        public String getAddress() {
            return Address;
        }

        public String getPhoneNr() {
            return PhoneNr;
        }

        public String getPassword() {
            return Password;
        }

        public String getPasswordConfirmation() {
            return PasswordConfirmation;
        }
    }

    public static class NameOfBanks extends ComboBox {
        public String Bank1 = "Nordea";
        public String Bank2 = "Danske Bank";
        public String Bank3 = "Sydbank";
        public String Bank4 = "Nykredit Bank";
        public String Bank5 = "Jyske Bank";
    }


    public class LoginModel {
        private String email;
        private String name;
        private String password;

        public LoginModel() {

        }

        public LoginModel(String email, String name, String password) {
            this.email = email;
            this.name = name;
            this.password = password;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

    }
}
