package com.service;

import com.model.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CustomerService {
    Session session;

    public CustomerService(Session session) {
        this.session = session;
    }

    public void addCustomer(Customer customer) {
      Transaction tx= session.beginTransaction();
      session.persist(customer);
      tx.commit();
    }

    public Customer getCustomerById(int id) {
        Transaction tx=session.beginTransaction();
       Customer customer= session.find(Customer.class,id);
       if(customer==null){
           throw new RuntimeException("id is now found");
       }
        tx.commit();
       return customer;
    }
}
