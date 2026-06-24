package atm.models;

import atm.enums.TransactionStatus;
import atm.enums.TransactionType;

public class Transaction {

    private String transactionId;

    private TransactionType transactionType;

    private int amount;

    private TransactionStatus transactionStatus;

    public Transaction(String transactionId, TransactionType transactionType, int amount, TransactionStatus transactionStatus) {

        this.transactionId = transactionId;
        this.transactionType = transactionType;
        this.amount = amount;
        this.transactionStatus = transactionStatus;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public int getAmount() {
        return amount;
    }

    public TransactionStatus getTransactionStatus() {
        return transactionStatus;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId='" + transactionId + '\'' +
                ", transactionType=" + transactionType +
                ", amount=" + amount +
                ", transactionStatus=" + transactionStatus +
                '}';
    }
}