package Model.Expenses;

import Exceptions.InsufficientBalanceException;
import Interface.Saveable;

import java.io.PrintWriter;

public class ExpenseCategory implements Saveable {
    public double budgetAmount;
    public double spentAmount;

    public ExpenseCategory(double amount) {
        this.budgetAmount = amount;
        this.spentAmount = 0.0;
    }

    public ExpenseCategory(double budget, double spent) {
        this.budgetAmount = budget;
        this.spentAmount = spent;
    }

    public boolean addTransaction(double amount) throws InsufficientBalanceException {
        if (this.spentAmount + amount >= this.budgetAmount) {
            throw new InsufficientBalanceException();
        } else {
            this.spentAmount += amount;
            return true;
        }
    }

    public String getName(String nam) {
        return nam;
    }


    @Override
    public void save(PrintWriter printWriter) {
        printWriter.print(this.budgetAmount);
        printWriter.print(",");
        printWriter.print(this.spentAmount);

    }
}
