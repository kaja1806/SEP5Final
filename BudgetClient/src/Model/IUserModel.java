package Model;


public interface IUserModel {
    String createUser(String FirstName, String LastName, String Email, String Address, String PhoneNr, String Password, String PasswordConfirmation);
}