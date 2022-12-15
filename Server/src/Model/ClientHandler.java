package Model;

import DB.*;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;

import java.io.Serializable;

public class ClientHandler implements IClientHandler, Serializable {

    private final UserDAO userDAO;
    private final BanksDAO banksDAO;
    private final ExpensesDAO expensesDAO;
    private final CategoryDAO categoryDAO;

    private final PaymentDAO paymentDAO;
    private final User_Authentication userAuthentication;


    public ClientHandler() {
        this.userDAO = new UserDAO();
        this.banksDAO = new BanksDAO();
        this.expensesDAO = new ExpensesDAO();
        this.categoryDAO = new CategoryDAO();
        this.paymentDAO = new PaymentDAO();
        this.userAuthentication = new User_Authentication();
    }

    @Override
    public String createUser(UserModel userModel) {
        return userDAO.createUser(userModel);
    }

    @Override
    public String addPayment(String categoryName, int amount) {
        return paymentDAO.addPayment(categoryName, amount);
    }

    @Override
    public int validateUser(String name, String pass) {
        return userAuthentication.isValid(name, pass);
    }

    @Override
    public ObservableList<Banks> getAllBanks() {
        return banksDAO.getAllBanks();
    }

    @Override
    public ObservableList<PieChart.Data> getAllExpenses() {
        return expensesDAO.getAllExpenses();
    }

    @Override
    public ObservableList<Category> getAllCategories() {
        return categoryDAO.getAllCategories();
    }

    @Override
    public String createCard(UserCardModel userCardModel, int income) {
        return userDAO.createCard(userCardModel, income);
    }

    @Override
    public ObservableList<UserCardModel> ifCardExistsPerUser() {
        return userDAO.ifCardExistsPerUser();
    }

    @Override
    public String updateCard(UserCardModel cardInput, int incomeParse) {
        return userDAO.updateCard(cardInput, incomeParse);
    }

    @Override
    public int getIncomePerUser() {
        return userDAO.getIncomePerUser();
    }
}