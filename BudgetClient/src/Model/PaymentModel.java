package Model;

import java.io.Serializable;

public class PaymentModel implements Serializable {
    private int amount;
    private String categoryName;

    public PaymentModel(int amount, String categoryName) {
        this.amount = amount;
        this.categoryName = categoryName;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return "PaymentModel{" + "amount=" + amount + ", categoryName='" + categoryName + '\'' + '}';
    }
}
