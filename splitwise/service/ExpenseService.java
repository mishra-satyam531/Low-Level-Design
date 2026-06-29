package splitwise.service;

import java.util.List;

import splitwise.models.Expense;
import splitwise.models.Group;
import splitwise.models.Split;
import splitwise.models.User;
import splitwise.strategy.SplitStrategy;

public class ExpenseService {
    public void addExpense(Group group, String expenseId, String description, int amount, User paidBy, SplitStrategy strategy) {

        List<Split> splits = strategy.calculateSplits(group.getMembers(), amount);

        Expense expense = new Expense(expenseId, description, amount, paidBy, splits);  

        group.addExpense(expense);
    }
}