package Handlers;

import Model.UserModel;

public interface IClientHelper {
    String createUser(UserModel userModel);

    int validateUser(String name, String pass);
}
