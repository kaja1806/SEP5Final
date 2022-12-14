package DB;

import Model.UserCardModel;
import Model.UserModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import static DB.User_Authentication.userModel;


public class UserDAO implements Serializable {

    private static final ResultSet resultSet = null;

    private Conn conn;

    public String createUser(UserModel userModel) {
        conn = Conn.getInstance();
        String sql =
                "INSERT INTO users(firstname,lastname,email,address,phonenr,password,nameofbank) "
                        + "values('" + userModel.getFirstName()
                        + "','" + userModel.getLastName()
                        + "','" + userModel.getEmail()
                        + "','" + userModel.getAddress()
                        + "','" + userModel.getPhoneNr()
                        + "','" + userModel.getPassword()
                        + "','" + userModel.getNameOfBank() + "');";
        String sqlgetuser = "SELECT * FROM users WHERE email = " + "'" + userModel.getEmail() + "'";

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

        String sql =
                "INSERT INTO usercard(cardholdername,cardnumber,validdate,cvc,userid,cardnickname) " + "values" +
                        "('" + userCard.getCardholderName() + "','" + userCard.getCardNumber() + "','" + userCard.getValidDate() + "','" + userCard.getCvc() + "','" + userModel.getUserID() + "','" + userCard.getCardNickname() + "');";
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

    public String updateCard(UserCardModel userCard, int income) {
        conn = Conn.getInstance();

        String sql =
                "UPDATE usercard SET " + "cardholdername = " + "'" + userCard.getCardholderName() + "'," + " " +
                        "cardnumber = " + userCard.getCardNumber() + "," + " " + "validdate = " + "'" + userCard.getValidDate() + "'," + " " + "cvc = " + userCard.getCvc() + "," + " " + "cardnickname = " + "'" + userCard.getCardNickname() + "'" + " " + "WHERE userid =" + userModel.getUserID() + ";";
        String sql2 = "UPDATE users SET " + "income = " + income + " " + "WHERE id =" + userModel.getUserID() + ";";
        try {
            conn.update(sql);
            conn.update(sql2);

        } catch (SQLException e) {
            if (e.getSQLState().equals("23505")) {
                return "Duplicate key";
            }
            e.printStackTrace();
        }
        return "Card Edited";
    }

    public ObservableList<UserCardModel> ifCardExistsPerUser() {
        conn = Conn.getInstance();
        ObservableList<UserCardModel> allCardsPerUser = FXCollections.observableArrayList();

        String sql = "SELECT cardholdername,cardnumber,validdate,cvc,userid,cardnickname FROM usercard WHERE userid= "
                + userModel.getUserID() + ";";
        try {
            ResultSet rs = conn.query(sql);
            while (rs.next()) {
                String name = rs.getString("cardholdername");
                String number = rs.getString("cardnumber");
                LocalDate valid = rs.getDate("validdate").toLocalDate();
                int cvc = rs.getInt("cvc");
                String nickname = rs.getString("cardnickname");
                allCardsPerUser.add(new UserCardModel(name, number, valid, cvc, nickname));
            }
            return allCardsPerUser;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int getIncomePerUser() {
        conn = Conn.getInstance();
        int income = 0;
        String sql = "SELECT income FROM users WHERE id= " + userModel.getUserID() + ";";
        try {
            ResultSet rs = conn.query(sql);
            while (rs.next()) {
                income = rs.getInt("income");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return income;
    }
}