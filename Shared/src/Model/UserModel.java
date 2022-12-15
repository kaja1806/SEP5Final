package Model;

public class UserModel {
    public String FirstName;
    public String LastName;
    public String Email;
    public String Address;
    public String NameOfBank = "";
    public String PhoneNr;
    public String Password;
    public String PasswordConfirmation;
    public int UserID = 0;
    public int Income;

    public UserModel() {

    }

    public UserModel(String firstName, String lastName, String email, String address, String phoneNr, String password
            , String passwordConfirmation, String nameOfBank) {
        FirstName = firstName;
        LastName = lastName;
        Email = email;
        Address = address;
        PhoneNr = phoneNr;
        Password = password;
        PasswordConfirmation = passwordConfirmation;
        NameOfBank = nameOfBank;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int userID) {
        UserID = userID;
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

    public String getNameOfBank() {
        return NameOfBank;
    }

    public int getIncome() {
        return Income;
    }
}
