package atm.strategy;

import java.util.Map;

public interface CashDispenser {

    Map<Integer, Integer> dispenseCash(int amount, Map<Integer, Integer> inventory);
}