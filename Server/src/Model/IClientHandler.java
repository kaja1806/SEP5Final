package Model;

import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;

public interface IClientHandler {
    String createUser(UserModel userModel);

    String addPayment(String categoryName, int amount);

    int validateUser(String name, String pass);

    ObservableList<Banks> getAllBanks();

    ObservableList<PieChart.Data> getAllExpenses();

    ObservableList<Category> getAllCategories();

    String createCard(UserCardModel userCardModel, int income);

    ObservableList<UserCardModel> ifCardExistsPerUser();

    String updateCard(UserCardModel cardInput, int incomeParse);

    int getIncomePerUser();
}
