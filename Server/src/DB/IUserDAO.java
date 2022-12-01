package DB;

import Model.UserModel;

public interface IUserDAO {
    String createUser(UserModel.RegistrationModel registrationModel);
}
