package BudgetClient;

import Model.UserModel;

public interface IBudgetClient {

    String createUser(UserModel userModel);
    int validateUser(String name, String pass);

}
