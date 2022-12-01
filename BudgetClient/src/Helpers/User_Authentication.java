package Helpers;

import Server.Server;

import java.rmi.RemoteException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class User_Authentication {
    public static int uid = -1;
    private static ResultSet resultSet = null;

    public static int isValid(String user_login, String pass) throws RemoteException {
        Server s = new Server();
        String sql = "SELECT * FROM users WHERE \"User\" = " + "'" + user_login + "'" + "AND \"Password\" = " + "'" + pass + "'";

        return 0;
    }
}

       /*// try {
            PreparedStatement stmt = s.getConnection().prepareStatement(sql);
            ResultSet sqlReturnValues = stmt.executeQuery();

            while (sqlReturnValues.next()) {
                uid = sqlReturnValues.getInt("user_login");
            }
            return uid;
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return uid;
    }*/