package Model;

import DB.UserDAO;
import DB.User_Authentication;

import java.io.Serializable;

public class ClientHandler implements IClientHandler, Serializable {

    private final UserDAO userDAO;
    private final User_Authentication userAuthentication;

    public ClientHandler() {
        this.userDAO = new UserDAO();
        this.userAuthentication = new User_Authentication();
    }

    @Override
    public String createUser(UserModel userModel) {
        return userDAO.createUser(userModel);
    }

    @Override
    public int validateUser(String name, String pass) {
        return userAuthentication.isValid(name, pass);
    }
}
