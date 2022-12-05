package DB;

import java.sql.SQLException;

public class PaymentDAO {

    private Conn conn;

    public String addPayment(String categoryName, int amount) {
        conn = Conn.getInstance();

        String sql = "INSERT INTO testtable values('" + amount + "','" + categoryName + "');";

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
