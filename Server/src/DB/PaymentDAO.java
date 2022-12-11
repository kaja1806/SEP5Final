package DB;

import Model.UserModel;

import java.sql.SQLException;

import static DB.User_Authentication.userModel;

public class PaymentDAO {

    private Conn conn;

    public String addPayment(String categoryName, int amount) {
        conn = Conn.getInstance();

        String sql = "INSERT INTO expenses(amount,userid,categoryname) values('" + amount
                + "','" + userModel.UserID + "','" + categoryName + "');";

        try {
            conn.update(sql);

        } catch (SQLException e) {
            if (e.getSQLState().equals("23505")) {
                return "Duplicate key";
            }
            e.printStackTrace();

        }
        return "Payment added";
    }
}
