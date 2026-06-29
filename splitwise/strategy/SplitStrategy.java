package splitwise.strategy;

import java.util.List;

import splitwise.models.User;
import splitwise.models.Split;

public interface SplitStrategy {
    List<Split> calculateSplits(List<User> users, int amount);
}