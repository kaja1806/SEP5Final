package Handlers;

import BudgetClient.IBudgetClient;
import Model.Banks;
import Model.Category;
import Model.UserCardModel;
import Model.UserModel;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;

public class ClientHelper implements IClientHelper {

    private final IBudgetClient handler;

    public ClientHelper(IBudgetClient h) {
        handler = h;
    }

    @Override
    public String createUser(UserModel userModel) {
        return handler.createUser(userModel);
    }

    @Override
    public int validateUser(String name, String pass) {
        return handler.validateUser(name, pass);
    }

    @Override
    public String addPayment(String categoryName, int amount) {
        return handler.addPayment(categoryName, amount);
    }

    @Override
    public int getIncomePerUser() {
        return handler.getIncomePerUser();
    }

    @Override
    public String createCard(UserCardModel cardInput, int incomeParse) {
        return handler.createCard(cardInput, incomeParse);
    }

    @Override
    public ObservableList<Banks> getAllBanks() {
        return handler.getAllBanks();
    }

    @Override
    public ObservableList<Category> getAllCategories() {
        return handler.getAllCategories();
    }

    @Override
    public ObservableList<PieChart.Data> getAllExpenses() {
        return handler.getAllExpenses();
    }

    @Override
    public ObservableList<UserCardModel> ifCardExistsPerUser() {
        return handler.ifCardExistsPerUser();
    }

    @Override
    public String updateCard(UserCardModel cardInput, int incomeParse) {
        return handler.updateCard(cardInput, incomeParse);
    }
}
