package DB;

import Model.Category;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryDAO implements Serializable {
    private Conn conn;

    public ObservableList<Category> getAllCategories() {

        conn = Conn.getInstance();

        ObservableList<Category> allCategories = FXCollections.observableArrayList();

        String sql = "SELECT * FROM category";

        try {
            ResultSet rs = conn.query(sql);
            while (rs.next()) {
                String categoryName = rs.getString("categoryname");
                allCategories.add(new Category(categoryName));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return allCategories;
    }
}
