package splitwise.models;

import java.util.List;

public class Group {
    private String groupId;

    private String groupName;

    private List<User> members;

    private List<Expense> expenses;

    public Group(String groupId, String groupName, List<User> members, List<Expense> expenses) {
        this.groupId = groupId;
        this.groupName = groupName;
        this.members = members;
        this.expenses = expenses;
    }

    public List<User> getMembers() {
        return members;
    }

    public List<Expense> getExpenses() {
        return expenses;
    }

    public void addExpense(Expense expense) {
        expenses.add(expense);
    }
}