package splitwise.models;

public class EqualSplit extends Split {

    private int amount;

    public EqualSplit(User user, int amount) {
        super(user);

        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }
}