package Model;

public interface IClientHandler {
    String createUser(UserModel userModel);

    int validateUser(String name, String pass);
}
