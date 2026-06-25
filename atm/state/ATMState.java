package atm.state;

import atm.models.ATM;
import atm.models.Card;

public interface ATMState {

    void insertCard(ATM atm, Card card);

    void enterPin(ATM atm, int pin);

    void withdraw(ATM atm, int amount);

    void checkBalance(ATM atm);

    void ejectCard(ATM atm);
}