package com.service;

import com.model.Account;
import com.model.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import java.util.List;

public class AccountService {
    Session session;

    public AccountService(Session session) {
        this.session=session;
    }
    public  void createAccount(Account account, String username){
        Transaction tx1 = session.beginTransaction();
     Query<Customer> query= session.createQuery("select c from Customer c where c.user.username=:username", Customer.class);
        query.setParameter("username",username);
       Customer customer= query.getSingleResult();
       account.setCustomer(customer);
        tx1.commit();
      Transaction tx = session.beginTransaction();
      session.persist(account);
        System.out.println(account);
        System.out.println("account added");

      tx.commit();
    }

    public Account getById(int id) {
        Transaction tx=session.beginTransaction();
       Query<Account> accountQuery= session.createQuery("select a from Account a where id=:id",Account.class);
       accountQuery.setParameter("id",id);
      Account acc= accountQuery.getSingleResult();

        tx.commit();
        return acc;
    }

    public void deleteAccount(int id, String username) {
        Account account=getById(id);
        Transaction transaction=session.beginTransaction();
        session.remove(account);
        transaction.commit();
        System.out.println("account deleted.");

    }

    public void updateAccount(Account account, int id) {
        Account acc=getById(id);
        acc.setIfsccode(account.getIfsccode());
        acc.setBranchname(account.getBranchname());
        acc.setAccounttype(account.getAccounttype());
        acc.setBalance(account.getBalance());
        Transaction tx=session.beginTransaction();
        session.persist(acc);
        tx.commit();
        System.out.println("account updated");
    }
    public List<Account> getAllAccounts(String username){
        Transaction tx=session.beginTransaction();
        Query<Account> query=session.createQuery("select a from Account a where a.customer.user.username=:username", Account.class);
        query.setParameter("username",username);
        List<Account> list=query.getResultList();
        tx.commit();
        return list;
    }
}
