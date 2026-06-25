package atm;

import java.util.HashMap;
import java.util.Map;

import atm.models.ATM;
import atm.models.BankAccount;
import atm.models.Card;
import atm.state.IdleState;
import atm.strategy.CashDispenser;
import atm.strategy.GreedyCashDispenser;

public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("ACC001", "Satyam", 25000);

        Card card = new Card("1234-5678-9012", 1234, account);

        Map<Integer, Integer> cashInventory = new HashMap<>();

        cashInventory.put(2000, 10);
        cashInventory.put(500, 20);
        cashInventory.put(100, 50);

        CashDispenser dispenser = new GreedyCashDispenser();

        ATM atm = new ATM("ATM001", cashInventory, dispenser, new IdleState());

        atm.insertCard(card);

        atm.enterPin(1234);

        atm.checkBalance();

        atm.withdraw(4600);

        atm.checkBalance();

        atm.ejectCard();
    }
}