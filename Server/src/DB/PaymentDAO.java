package DB;

import Model.UserModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static DB.User_Authentication.userModel;

public class PaymentDAO {

    private Conn conn;
    private boolean exists = false;

    public String addPayment(String categoryName, int amount) {
        List<String> categoryCheck = checkForCategory();

        for (String check : categoryCheck) {
            if (check.equals(categoryName)) {
                updateExistingExpense(categoryName, amount);
                exists = true;
            }
        }
        if (!exists) {
            addNewExpense(categoryName, amount);
            return "Expense added";
        }

        return "Expense updated";
    }

    public String addNewExpense(String categoryName, int amount) {
        conn = Conn.getInstance();

        try {
            String insert =
                    "INSERT INTO expenses(amount,userid,categoryname) values('" + amount + "','" + userModel.UserID + "'," + "'" + categoryName + "');";
            conn.update(insert);
        } catch (SQLException e) {
            if (e.getSQLState().equals("23505")) {
                return "Duplicate key";
            }
            e.printStackTrace();
        }
        return "Expense added";
    }

    public void updateExistingExpense(String categoryName, int amount) {
        conn = Conn.getInstance();
        try {
            String dbamount = "SELECT amount FROM expenses WHERE categoryname =" + "'" + categoryName + "'" + ";";
            ResultSet rsAmount = conn.query(dbamount);
            while (rsAmount.next()) {
                int dbBeforeAmount = rsAmount.getInt("amount");
                int totalAmount = dbBeforeAmount + amount;
                String update =
                        "UPDATE expenses SET amount = " + totalAmount + " WHERE categoryname =" + "'" + categoryName + "'" + ";";
                conn.update(update);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<String> checkForCategory() {
        conn = Conn.getInstance();

        List<String> categories = new ArrayList<>();

        String check = "SELECT categoryname FROM expenses";

        try {
            ResultSet rs = conn.query(check);
            while (rs.next()) {
                String dbcategoryname = rs.getString("categoryname");
                categories.add(new String(dbcategoryname));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return categories;

    }
}



