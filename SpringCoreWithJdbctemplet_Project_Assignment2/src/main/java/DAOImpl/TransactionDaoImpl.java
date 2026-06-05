package DAOImpl;

import DAO.TransactionDAO;
import enums.TransactionStatus;
import enums.TransactionType;
import model.Transaction;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TransactionDaoImpl implements TransactionDAO {
    JdbcTemplate jdbcTemplate;

    public TransactionDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void insertTransaction(Transaction transaction) {
        String Q="insert into transactions(amount,transactionStatus,transactionType,accountno) values(?,?,?,?)";

      jdbcTemplate.update(Q,transaction.getAmount(),transaction.getTransactionStatus().toString(),transaction.getTransactionType().toString(),transaction.getAccountNo());
        System.out.println("transaction inserted");
    }

    @Override
    public List<Transaction> fetchAllTransactions() {
       String q="select * from transactions";
     return   jdbcTemplate.query(q,(rs,n)->{
           return new Transaction(rs.getInt(1),rs.getDouble(2), TransactionStatus.valueOf(rs.getString(3)), TransactionType.valueOf(rs.getString(4)),rs.getString(5));
       });

    }

    @Override
    public Transaction getById(int id) {
        String q="select * from transactions where id=?";
      Transaction transaction=  jdbcTemplate.queryForObject(q,(rs,n)->{
          return new Transaction(rs.getInt(1),rs.getDouble(2), TransactionStatus.valueOf(rs.getString(3)), TransactionType.valueOf(rs.getString(4)),rs.getString(5));
      },id);
        return transaction;
    }

    @Override
    public void deleteById(int id) {
     jdbcTemplate.update("delete from transactions where id=?",id);
        System.out.println("Account is deleted");
    }

    @Override
    public void updateTransaction(Transaction transaction) {
String q="update transactions set transactionType=? where id=?";
jdbcTemplate.update(q,transaction.getTransactionType().toString(),transaction.getId());
        System.out.println("Transaction is updated");
    }
}
