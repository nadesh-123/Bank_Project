import DAO.TransactionDAO;
import DAOImpl.TransactionDaoImpl;
import config.SpringConfig;
import enums.TransactionStatus;
import enums.TransactionType;
import model.Transaction;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;
import java.util.List;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(SpringConfig.class);
        Scanner sc=new Scanner(System.in);
        TransactionDAO transactionDAO=context.getBean(TransactionDaoImpl.class);
      while(true){
          System.out.println("1.insert into transaction");
          System.out.println("2.delete transaction");
          System.out.println("3.get transaction by id");
          System.out.println("4.update the transaction");
          System.out.println("5.fetch all transactions");
          int ch=sc.nextInt();
          if(ch==0){
              break;
          }
          switch (ch){
              case 1:
                  System.out.println("Enter the amount");
                  double amount=sc.nextDouble();
                  System.out.println("enter the transaction type");
                  sc.nextLine();
                  TransactionType transactionType=TransactionType.valueOf(sc.nextLine());
                  System.out.println("enter the account number");
                  String accno=sc.nextLine();
                 transactionDAO.insertTransaction(new Transaction(amount, TransactionStatus.SUCCESS,transactionType,accno));
              break;
              case 2:
                  System.out.println("enter the id:");
                  int id=sc.nextInt();
                  transactionDAO.deleteById(id);

                  break;
              case 3:
                  System.out.println("enter the id:");
                  id=sc.nextInt();
                  Transaction transaction=transactionDAO.getById(id);
                  System.out.println(transaction);
                  break;
              case 4:
                  System.out.println("Enter the id to be updated:");
                  id=sc.nextInt();
                 Transaction transaction1= transactionDAO.getById(id);
                  System.out.println(transaction1);
                  transaction1.setTransactionType(TransactionType.TRANSFER);
                  transactionDAO.updateTransaction(transaction1);

                  break;

              case 5:
                  List<Transaction> list=transactionDAO.fetchAllTransactions();
                  list.forEach(System.out::println);
          }
      }
    }
}
