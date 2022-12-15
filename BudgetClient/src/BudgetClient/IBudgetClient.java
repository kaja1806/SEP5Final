package BudgetClient;

import Model.Banks;
import Model.Category;
import Model.UserCardModel;
import Model.UserModel;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;

public interface IBudgetClient {

    String createUser(UserModel userModel);

    String createCard(UserCardModel cardInput, int incomeParse);

    int validateUser(String name, String pass);

    String addPayment(String categoryName, int amount);

    String updateCard(UserCardModel cardInput, int incomeParse);

    int getIncomePerUser();

    ObservableList<Banks> getAllBanks();

    ObservableList<Category> getAllCategories();

    ObservableList<PieChart.Data> getAllExpenses();

    ObservableList<UserCardModel> ifCardExistsPerUser();

}
