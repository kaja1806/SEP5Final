package Model;

import DB.IUserDAO;


public class UserToDB implements IUserModel {

    UserModel.RegistrationModel registrationModel;
    private IUserDAO client;

    @Override
    public String createUser(String FirstName, String LastName, String Email, String Address, String PhoneNr, String Password, String PasswordConfirmation) {
        registrationModel = new UserModel.RegistrationModel(FirstName, LastName, Email, Address, PhoneNr, Password, PasswordConfirmation);
        return client.createUser(registrationModel);
    }
}
