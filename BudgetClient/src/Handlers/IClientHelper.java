package Handlers;

import Model.Banks;
import Model.Category;
import Model.UserCardModel;
import Model.UserModel;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;

public interface IClientHelper {
    String createUser(UserModel userModel);

    int validateUser(String name, String pass);

    String addPayment(String categoryName, int amount);

    int getIncomePerUser();

    String createCard(UserCardModel cardInput, int incomeParse);

    ObservableList<Banks> getAllBanks();

    ObservableList<Category> getAllCategories();

    ObservableList<PieChart.Data> getAllExpenses();

    ObservableList<UserCardModel> ifCardExistsPerUser();

    String updateCard(UserCardModel cardInput, int incomeParse);
}
