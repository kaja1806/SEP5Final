package Helpers;

import DB.Conn;
import Model.UserModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class User_Authentication {

    private static final ResultSet resultSet = null;
    private static Conn conn;

   public static UserModel.RegistrationModel userModel;


    public static int isValid(String name, String pass) {
        conn = Conn.getInstance();
        UserModel.RegistrationModel user = new UserModel.RegistrationModel();

        String sql = "SELECT * FROM users WHERE email = " + "'" + name + "'" + " AND password = " + "'" + pass + "'";

        try {

            ResultSet rs = conn.query(sql);
            while (rs.next()) {
               user.UserID = rs.getInt("id");
            }
            return user.getUserID();
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return user.getUserID();
    }
}