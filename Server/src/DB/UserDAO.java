package DB;

import Model.UserModel;

import java.sql.SQLException;

public class UserDAO{

    private Conn conn;

    public String createUser(UserModel.RegistrationModel registrationModel)  {
    conn = Conn.getInstance();
        String sql = "INSERT INTO users values('" + registrationModel.getFirstName() + "','"
                + registrationModel.getLastName() + "','"
                + registrationModel.getEmail() + "','"
                + registrationModel.getAddress() + "','"
                + registrationModel.getPhoneNr() + "','"
                + registrationModel.getPassword() + "');";
        try {
            conn.update(sql);

        } catch (SQLException e) {
            if (e.getSQLState().equals("23505")) {
                return "Duplicate key";
            }
            e.printStackTrace();

        }
        return "User added";
    }
}
