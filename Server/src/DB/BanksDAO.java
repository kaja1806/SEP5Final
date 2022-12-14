package DB;

import Model.Banks;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BanksDAO {

    private Conn conn;

    public ObservableList<Banks> getAllBanks() {

        conn = Conn.getInstance();

        ObservableList<Banks> allBanks = FXCollections.observableArrayList();

        String sql = "SELECT * FROM listofbanks";

        try {
            ResultSet rs = conn.query(sql);
            while (rs.next()) {

                String bankName = rs.getString("nameofbank");
                allBanks.add(new Banks(bankName));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return allBanks;
    }
}
