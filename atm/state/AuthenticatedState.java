package atm.state;

import java.util.Map;

import atm.models.ATM;
import atm.models.BankAccount;
import atm.models.Card;

public class AuthenticatedState implements ATMState {

    @Override
    public void insertCard(ATM atm, Card card) {
        System.out.println("A card is already inserted.");  
    }

    @Override
    public void enterPin(ATM atm, int pin) {
        System.out.println("PIN already verified.");
    }

    @Override
    public void withdraw(ATM atm, int amount) {
        BankAccount account = atm.getCurrentCard().getBankAccount();

        if(account.getBalance() < amount) {
            System.out.println("Insufficient Account Balance.");
            return;
        }

        Map<Integer, Integer> dispensedNotes = atm.getCashDispenser().dispenseCash(amount, atm.getCashInventory());

        if(dispensedNotes == null) {
            System.out.println("ATM cannot dispense requested amount.");
            return;
        }

        account.withdraw(amount);

        System.out.println("Collect your cash:");

        for(Map.Entry<Integer, Integer> entry : dispensedNotes.entrySet()) {
            System.out.println("Rs " + entry.getKey() + " x " + entry.getValue());
        }
    }

    @Override
    public void checkBalance(ATM atm) {
        System.out.println("Balance : Rs " + atm.getCurrentCard().getBankAccount().getBalance());
    }

    @Override
    public void ejectCard(ATM atm) {
        atm.endSession();
        atm.changeState(new IdleState());

        System.out.println("Card ejected.");
    }

}