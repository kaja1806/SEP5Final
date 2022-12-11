package DB;

import Model.UserCardModel;
import Model.UserModel;

import java.sql.ResultSet;
import java.sql.SQLException;

import static DB.User_Authentication.userModel;

public class UserDAO {

    private Conn conn;
    private static final ResultSet resultSet = null;



    public String createUser(UserModel.RegistrationModel registrationModel) {
        conn = Conn.getInstance();
        UserModel.RegistrationModel userModel = new UserModel.RegistrationModel();
        String sql = "INSERT INTO users(firstname,lastname,email,address,phonenr,password,nameofbank) " +
                "values('" + registrationModel.getFirstName() + "','"
                + registrationModel.getLastName() + "','"
                + registrationModel.getEmail() + "','"
                + registrationModel.getAddress() + "','"
                + registrationModel.getPhoneNr() + "','"
                + registrationModel.getPassword() + "','"
                + registrationModel.getNameOfBank() + "');";
        String sqlgetuser = "SELECT * FROM users WHERE email = " + "'" + registrationModel.getEmail() + "'";

        try {
            conn.update(sql);
            ResultSet rs = conn.query(sqlgetuser);
            while (rs.next()) {
                userModel.setUserID(rs.getInt("id"));
            }

        } catch (SQLException e) {
            if (e.getSQLState().equals("23505")) {
                return "Duplicate key";
            }
            e.printStackTrace();
        }
        return "User added";
    }

    public String createCard(UserCardModel userCard, int income) {
        conn = Conn.getInstance();

        String sql = "INSERT INTO usercard(cardholdername,cardnumber,validdate,cvc,userid) " +
                "values('" + userCard.getCardholderName() + "','"
                + userCard.getCardNumber() + "','"
                + userCard.getValidDate() + "','"
                + userCard.getCvc() + "','"
                + userModel.getUserID() + "');";
        String sql2 = "UPDATE users SET income = " + income + " WHERE id =" + userModel.getUserID() + ";";
        try {
            conn.update(sql);
            conn.update(sql2);

        } catch (SQLException e) {
            if (e.getSQLState().equals("23505")) {
                return "Duplicate key";
            }
            e.printStackTrace();
        }
        return "Card Added";
    }
}