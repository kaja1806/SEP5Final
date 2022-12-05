package Model.Income;

//import Classes.AssetReader;

import Interface.Saveable;

import java.io.PrintWriter;

public class Assets implements Saveable {
    String name;
    double amount;

    public Assets(String name, double amount) {
        this.name = name;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public void save(PrintWriter printWriter) {
        printWriter.println("Title of the asset: " + name);
        printWriter.println("Amount received: " + amount);
    }
}
