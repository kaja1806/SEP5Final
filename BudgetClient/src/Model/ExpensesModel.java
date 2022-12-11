package Model;

public class ExpensesModel {
    public String CategoryName;
    public int Amount;

    public ExpensesModel(String categoryName, int amount) {
        this.CategoryName = categoryName;
        this.Amount = amount;
    }
}
