package DAO;

import model.Transaction;

import java.util.List;

public interface TransactionDAO {
    void insertTransaction(Transaction transaction);
    List<Transaction> fetchAllTransactions();
    Transaction getById(int id);
    void deleteById(int id);
    void updateTransaction(Transaction transaction);
}
