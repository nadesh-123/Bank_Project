package model;

import enums.TransactionStatus;
import enums.TransactionType;

public class Transaction {
    private int id;
    private double amount ;
    private TransactionStatus transactionStatus;
    private TransactionType transactionType;
    private String accountNo ;

    public Transaction(double amount, TransactionStatus transactionStatus, TransactionType transactionType, String accountNo) {
        this.amount = amount;
        this.transactionStatus = transactionStatus;
        this.transactionType = transactionType;
        this.accountNo = accountNo;
    }

    public Transaction(int id, double amount, TransactionStatus transactionStatus, TransactionType transactionType, String accountNo) {
        this.id = id;
        this.amount = amount;
        this.transactionStatus = transactionStatus;
        this.transactionType = transactionType;
        this.accountNo = accountNo;
    }

    public Transaction() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public TransactionStatus getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(TransactionStatus transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", amount=" + amount +
                ", transactionStatus=" + transactionStatus +
                ", transactionType=" + transactionType +
                ", accountNo='" + accountNo + '\'' +
                '}';
    }
}
