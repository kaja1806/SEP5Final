package Server;

import Interface.IServerClient;
import Model.*;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;

import java.rmi.RemoteException;

public class ServerClientHandler implements IServerClient {

    private final IClientHandler clientHandler;

    public ServerClientHandler() throws RemoteException {
        clientHandler = new ClientHandler();
    }

    public String createUser(UserModel userModel) {
        return clientHandler.createUser(userModel);
    }

    @Override
    public String createCard(UserCardModel userCardModel, int income) throws RemoteException {
        return clientHandler.createCard(userCardModel, income);
    }

    public int validateUser(String name, String pass) {
        return clientHandler.validateUser(name, pass);
    }

    @Override
    public String addPayment(String categoryName, int amount) throws RemoteException {
        return clientHandler.addPayment(categoryName, amount);
    }

    @Override
    public int getIncomePerUser() {
        return clientHandler.getIncomePerUser();
    }

    @Override
    public String updateCard(UserCardModel cardInput, int incomeParse) {
        return clientHandler.updateCard(cardInput, incomeParse);
    }

    @Override
    public ObservableList<Banks> getAllBanks() throws RemoteException {
        return clientHandler.getAllBanks();
    }

    @Override
    public ObservableList<Category> getAllCategories() throws RemoteException {
        return clientHandler.getAllCategories();
    }

    @Override
    public ObservableList<PieChart.Data> getAllExpenses() throws RemoteException {
        return clientHandler.getAllExpenses();
    }

    @Override
    public ObservableList<UserCardModel> ifCardExistsPerUser() {
        return clientHandler.ifCardExistsPerUser();
    }
}