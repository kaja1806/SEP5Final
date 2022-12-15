package BudgetClient;

import Interface.IServer;
import Model.Banks;
import Model.Category;
import Model.UserCardModel;
import Model.UserModel;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class BudgetClient implements IBudgetClient {
    private final IServer server;

    public BudgetClient() throws RemoteException, NotBoundException, MalformedURLException {
        server = (IServer) Naming.lookup("rmi://localhost:1099/Budget");
        server.message("Budget Client Connected");
    }

    @Override
    public String createUser(UserModel userModel) {
        try {
            return server.getClient().createUser(userModel);
        } catch (RemoteException e) {
            return "Error";
        }
    }

    @Override
    public int validateUser(String name, String pass) {
        try {
            return server.getClient().validateUser(name, pass);
        } catch (RemoteException e) {
            return 0;
        }
    }

    @Override
    public String createCard(UserCardModel cardInput, int incomeParse) {
        try {
            return server.getClient().createCard(cardInput, incomeParse);
        } catch (RemoteException e) {
            return "Error";
        }
    }

    @Override
    public String updateCard(UserCardModel cardInput, int incomeParse) {
        try {
            return server.getClient().updateCard(cardInput, incomeParse);
        } catch (RemoteException e) {
            return "Error";
        }
    }

    @Override
    public String addPayment(String categoryName, int amount) {
        try {
            return server.getClient().addPayment(categoryName, amount);
        } catch (RemoteException e) {
            return "Error";
        }
    }

    @Override
    public int getIncomePerUser() {
        try {
            return server.getClient().getIncomePerUser();
        } catch (RemoteException e) {
            return 0;
        }
    }

    @Override
    public ObservableList<Banks> getAllBanks() {
        try {
            return server.getClient().getAllBanks();
        } catch (RemoteException e) {
            return null;
        }
    }

    @Override
    public ObservableList<Category> getAllCategories() {
        try {
            return server.getClient().getAllCategories();
        } catch (RemoteException e) {
            return null;
        }
    }

    @Override
    public ObservableList<PieChart.Data> getAllExpenses() {
        try {
            return server.getClient().getAllExpenses();
        } catch (RemoteException e) {
            return null;
        }
    }

    @Override
    public ObservableList<UserCardModel> ifCardExistsPerUser() {
        try {
            return server.getClient().ifCardExistsPerUser();
        } catch (RemoteException e) {
            return null;
        }
    }
}
