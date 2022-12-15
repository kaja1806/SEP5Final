package Interface;

import Model.Banks;
import Model.Category;
import Model.UserCardModel;
import Model.UserModel;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IServerClient extends Remote, Serializable {

    String createUser(UserModel userModel) throws RemoteException;

    String createCard(UserCardModel userCardModel, int income) throws RemoteException;

    int validateUser(String name, String pass) throws RemoteException;

    String addPayment(String categoryName, int amount) throws RemoteException;

    int getIncomePerUser();

    String updateCard(UserCardModel cardInput, int incomeParse);

    ObservableList<Banks> getAllBanks() throws RemoteException;

    ObservableList<Category> getAllCategories() throws RemoteException;

    ObservableList<PieChart.Data> getAllExpenses() throws RemoteException;

    ObservableList<UserCardModel> ifCardExistsPerUser();


}
