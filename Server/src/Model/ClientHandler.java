package Model;

import DB.UserDAO;

import java.io.Serializable;

public class ClientHandler implements IClientHandler, Serializable {

    private final UserDAO userDAO;

    public ClientHandler() {
        this.userDAO = new UserDAO();
    }

    @Override
    public String createUser(UserModel userModel) {
        return userDAO.createUser(userModel);
    }
}
