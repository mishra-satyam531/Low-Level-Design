package atm.state;

import atm.models.ATM;
import atm.models.Card;

public class CardInsertedState implements ATMState {

    @Override
    public void insertCard(ATM atm, Card card) {
        System.out.println("A card is already inserted.");
    }

    @Override
    public void enterPin(ATM atm, int pin) {
        if(atm.getCurrentCard().validatePin(pin)) {

            atm.resetFailedPinAttempts();
            atm.changeState(new AuthenticatedState());

            System.out.println("PIN verified successfully.");
        } else {
            atm.incrementFailedPinAttempts();

            if(atm.getFailedPinAttempts() == 3) {

                System.out.println("3 incorrect attempts. Card ejected.");

                atm.endSession();
                atm.changeState(new IdleState());
            } else {
                System.out.println("Incorrect PIN. Attempts Left : " + (3 - atm.getFailedPinAttempts()));
            }
        }
    }

    @Override
    public void withdraw(ATM atm, int amount) {
        System.out.println("Please enter PIN first.");
    }

    @Override
    public void checkBalance(ATM atm) {
        System.out.println("Please enter PIN first.");
    }

    @Override
    public void ejectCard(ATM atm) {
        atm.endSession();
        atm.changeState(new IdleState());

        System.out.println("Card ejected.");
    }

}