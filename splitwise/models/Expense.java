package splitwise.models;

import java.util.List;

public class Expense {
     private String expenseId;

    private String description;

    private int amount;

    private User paidBy;

    private List<Split> splits;

    public Expense(String expenseId, String description, int amount, User paidBy, List<Split> splits) {
        this.expenseId = expenseId;
        this.description = description;
        this.amount = amount;
        this.paidBy = paidBy;
        this.splits = splits;
    }

    public int getAmount() {
        return amount;
    }

    public User getPaidBy() {
        return paidBy;
    }

    public List<Split> getSplits() {
        return splits;
    }

    public String getDescription() {
        return description;
    }
}