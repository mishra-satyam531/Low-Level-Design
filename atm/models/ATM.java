package atm.models;

import java.util.Map;

import atm.strategy.CashDispenser;

public class ATM {
    private String atmId;

    private Card currentCard;

    private Map<Integer, Integer> cashInventory;

    private CashDispenser cashDispenser;

    private boolean authenticated;

    public ATM(String atmId, Map<Integer, Integer> cashInventory, CashDispenser cashDispenser) {
        this.atmId = atmId;
        this.cashInventory = cashInventory;
        this.cashDispenser = cashDispenser;
        this.authenticated = false;
    }

    public void insertCard(Card card) {
        if (currentCard != null) {
            System.out.println("Another card is already inserted.");
            return;
        }

        currentCard = card;
        authenticated = false;

        System.out.println("Card inserted successfully.");
    }

    public boolean enterPin(int pin) {
        if (currentCard == null) {
            System.out.println("Please insert a card first.");
            return false;
        }

        authenticated = currentCard.validatePin(pin);

        if (authenticated) {
            System.out.println("PIN verified successfully.");
        } else {
            System.out.println("Incorrect PIN.");
        }

        return authenticated;
    }

    public void checkBalance() {

        if (!authenticated) {
            System.out.println("Please authenticate first.");
            return;
        }

        System.out.println("Available Balance : ₹" + currentCard.getBankAccount().getBalance());
    }

    public void withdraw(int amount) {

        if (!authenticated) {
            System.out.println("Please authenticate first.");
            return;
        }

        BankAccount account = currentCard.getBankAccount();

        if (account.getBalance() < amount) {
            System.out.println("Insufficient account balance.");
            return;
        }

        Map<Integer, Integer> dispensedNotes = cashDispenser.dispenseCash(amount, cashInventory);

        if (dispensedNotes == null) {
            System.out.println("ATM cannot dispense the requested amount.");
            return;
        }

        account.withdraw(amount);

        System.out.println("Please collect your cash.");

        System.out.println("Notes Dispensed:");

        for (Map.Entry<Integer, Integer> entry : dispensedNotes.entrySet()) {

            System.out.println("₹" + entry.getKey() + " x " + entry.getValue());
        }
    }
}