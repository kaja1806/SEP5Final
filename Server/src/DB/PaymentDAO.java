package DB;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

import static DB.User_Authentication.userModel;

public class PaymentDAO implements Serializable {

    private Conn conn;

    public String addPayment(String categoryName, int amount) {

        boolean update = updateExistingExpense(categoryName, amount);

        if (!update) {
            addNewExpense(categoryName, amount);
            return "Expense added";
        }
        return "Expense updated";
    }

    public void addNewExpense(String categoryName, int amount) {
        conn = Conn.getInstance();

        try {
            String insert =
                    "INSERT INTO expenses(amount,userid,categoryname) values('" + amount + "','" + userModel.UserID + "'," + "'" + categoryName + "');";
            conn.update(insert);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean updateExistingExpense(String categoryName, int amount) {
        conn = Conn.getInstance();
        try {
            String dbamount = "SELECT amount FROM expenses WHERE categoryname =" + "'" + categoryName + "' AND userid =" + "'" + userModel.UserID + "'" + ";";
            ResultSet rsAmount = conn.query(dbamount);
            while (rsAmount.next()) {
                int dbBeforeAmount = rsAmount.getInt("amount");
                int totalAmount = dbBeforeAmount + amount;
                String update =
                        "UPDATE expenses SET amount = " + totalAmount + " WHERE categoryname =" + "'" + categoryName + "'" + ";";
                conn.update(update);
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}