package Model;

import java.io.Serializable;

public class Payment implements Serializable {

    private int paymentAmount;
    private String date;

    public Payment(int paymentAmount, String date) {
        this.paymentAmount = paymentAmount;
        this.date = date;
    }

    public int getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(int paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Payment{" + "paymentAmount" + paymentAmount + ", date = " + date + '\'' + '}';
    }
}
