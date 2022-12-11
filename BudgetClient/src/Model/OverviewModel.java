package Model;

import javafx.collections.ObservableList;

import java.io.Serializable;

public class OverviewModel implements Serializable{

    private int amount;
    private String category;

    public OverviewModel(int amount, String category) {
        this.amount = amount;
        this.category = category;
    }

    public int getAmount(){
        return amount;
    }

    public void setAmount(int amount){
        this.amount=amount;
    }

    public String getCategory(){
        return category;
    }

    public void setCategory(String category){
        this.category=category;
    }

    @Override
    public String toString(){
        return "OverviewModel:{" +
                "amount=" + amount +
                ", category= " + category + '\'' +
                '}';
    }

    public ObservableList<OverviewModel> getAllPayment() {
        int getAmount;
        String getCategory;
        return getAllPayment();
    }
}

