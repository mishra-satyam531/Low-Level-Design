package atm.models;

import java.util.Map;

import atm.state.ATMState;
import atm.strategy.CashDispenser;

public class ATM {
    private String atmId;

    private Card currentCard;

    private ATMState currentState;

    private CashDispenser cashDispenser;

    private Map<Integer, Integer> cashInventory;

    private int failedPinAttempts;

    public ATM(String atmId, Map<Integer, Integer> cashInventory, CashDispenser cashDispenser, ATMState initialState) {

        this.atmId = atmId;
        this.cashInventory = cashInventory;
        this.cashDispenser = cashDispenser;
        this.currentState = initialState;
        this.failedPinAttempts = 0;
    }

    // ---------- Methods used by client ----------
    
    public void insertCard(Card card) {
        currentState.insertCard(this, card);
    }

    public void enterPin(int pin) {
        currentState.enterPin(this, pin);
    }

    public void withdraw(int amount) {
        currentState.withdraw(this, amount);
    }

    public void checkBalance() {
        currentState.checkBalance(this);
    }

    public void ejectCard() {
        currentState.ejectCard(this);
    }

    // ---------- Methods used by States ----------

    public void startSession(Card card) {
        currentCard = card;
        failedPinAttempts = 0;
    }

    public void endSession() {
        currentCard = null;
        failedPinAttempts = 0;
    }

    public void changeState(ATMState state) {
        currentState = state;
    }

    public void incrementFailedPinAttempts() {
        failedPinAttempts++;
    }

    public void resetFailedPinAttempts() {
        failedPinAttempts = 0;
    }

    public int getFailedPinAttempts() {
        return failedPinAttempts;
    }

    public Card getCurrentCard() {
        return currentCard;
    }

    public CashDispenser getCashDispenser() {
        return cashDispenser;
    }

    public Map<Integer, Integer> getCashInventory() {
        return cashInventory;
    }
}