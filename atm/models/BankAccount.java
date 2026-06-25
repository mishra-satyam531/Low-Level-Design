package atm.models;

public class BankAccount {

    private String accountNumber;

    private String accountHolderName;

    private int balance;

    public BankAccount(String accountNumber, String accountHolderName, int balance) {

        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public int getBalance() {
        return balance;
    }

    public boolean withdraw(int amount) {

        if(balance < amount) {
            return false;
        }

        balance -= amount;

        return true;
    }

    public void deposit(int amount) {
        balance += amount;
    }

    @Override
    public String toString() {
        return "BankAccount{" + "accountNumber='" + accountNumber + '\'' + ", accountHolderName='" + accountHolderName + '\'' + ", balance=" + balance + '}';
    }
}