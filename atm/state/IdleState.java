package atm.state;

import atm.models.ATM;
import atm.models.Card;

public class IdleState implements ATMState {

    @Override
    public void insertCard(ATM atm, Card card) {
        atm.startSession(card);

        atm.changeState(new CardInsertedState());

        System.out.println("Card inserted successfully.");
    }

    @Override
    public void enterPin(ATM atm, int pin) {
        System.out.println("Please insert a card first.");
    }

    @Override
    public void withdraw(ATM atm, int amount) {
        System.out.println("Please insert a card first.");
    }

    @Override
    public void checkBalance(ATM atm) {
        System.out.println("Please insert a card first.");
        throw new UnsupportedOperationException("Unimplemented method 'checkBalance'");
    }

    @Override
    public void ejectCard(ATM atm) {
        System.out.println("Please insert a card first.");
    }
    
}