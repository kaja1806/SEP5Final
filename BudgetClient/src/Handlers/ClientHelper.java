package Handlers;

import BudgetClient.IBudgetClient;
import Model.UserModel;

public class ClientHelper implements IClientHelper {

    private final IBudgetClient handler;

    public ClientHelper(IBudgetClient h) {
        handler = h;
    }

    @Override
    public String createUser(UserModel userModel) {
        return handler.createUser(userModel);
    }

    @Override
    public int validateUser(String name, String pass) {
        return handler.validateUser(name, pass);
    }
}
