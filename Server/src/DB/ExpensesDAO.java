package DB;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;

import java.sql.ResultSet;
import java.sql.SQLException;

import static DB.User_Authentication.userModel;


public class ExpensesDAO {
    private Conn conn;

    public ObservableList<PieChart.Data> getAllExpenses() {

        conn = Conn.getInstance();

        ObservableList<PieChart.Data> allExpenses = FXCollections.observableArrayList();

        String sql = "SELECT amount, userid, categoryname FROM expenses WHERE userid =" + userModel.getUserID() + ";";

        try {
            ResultSet rs = conn.query(sql);
            while (rs.next()) {

                String categoryName = rs.getString("categoryname");
                int amount = rs.getInt("amount");
                allExpenses.add(new PieChart.Data(categoryName, amount));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allExpenses;
    }
}
