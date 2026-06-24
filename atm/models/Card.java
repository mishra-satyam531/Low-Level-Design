package atm.models;

public class Card {

    private String cardNumber;

    private int pin;

    private BankAccount bankAccount;

    public Card(String cardNumber, int pin, BankAccount bankAccount) {

        this.cardNumber = cardNumber;
        this.pin = pin;
        this.bankAccount = bankAccount;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public boolean validatePin(int enteredPin) {
        return pin == enteredPin;
    }

    @Override
    public String toString() {
        return "Card{" +
                "cardNumber='" + cardNumber + '\'' +
                '}';
    }
}