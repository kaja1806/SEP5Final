package Helpers;

import DB.Conn;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class User_Authentication {

    public static int uid = -1;
    private static ResultSet resultSet = null;
    private static Conn conn;



    public static int isValid(String name, String pass) {
        conn = Conn.getInstance();

        String sql = "SELECT * FROM users WHERE email = " + "'" + name + "'" + " AND password = " + "'" + pass + "'";

        try {
            ResultSet rs = conn.query(sql);
            while (rs.next()) {
                uid = rs.getInt("id");
            }

            return uid;
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return uid;
    }
}
