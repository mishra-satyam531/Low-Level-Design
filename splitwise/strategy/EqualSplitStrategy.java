package splitwise.strategy;

import java.util.ArrayList;
import java.util.List;

import splitwise.models.User;
import splitwise.models.EqualSplit;
import splitwise.models.Split;

public class EqualSplitStrategy implements SplitStrategy {
    @Override
    public List<Split> calculateSplits(List<User> users, int amount) {

        List<Split> splits = new ArrayList<>();

        int share = amount / users.size();

        for(User user : users) {
            splits.add(new EqualSplit(user, share));
        }

        return splits;
    }
}