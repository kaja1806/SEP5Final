package DB;

import Model.UserModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class User_Authentication {

    private static final ResultSet resultSet = null;
    public static UserModel.RegistrationModel userModel = new UserModel.RegistrationModel();
    private static Conn conn;

    public static int isValid(String name, String pass) {
        conn = Conn.getInstance();

        String sql = "SELECT * FROM users WHERE email = " + "'" + name + "'" + " AND password = " + "'" + pass + "'";

        try {

            ResultSet rs = conn.query(sql);
            while (rs.next()) {
                userModel.setUserID(rs.getInt("id"));
            }
            return userModel.getUserID();
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return userModel.getUserID();
    }

    public static int getUserID() {
        return userModel.UserID;
    }


}