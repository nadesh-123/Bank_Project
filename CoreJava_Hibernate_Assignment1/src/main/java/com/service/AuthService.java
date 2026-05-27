package com.service;


import com.ResourceNotFoundException;
import com.model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AuthService {
Session session;
    public AuthService(Session session) {
        this.session=session;
    }

    public User verifyUser(String username, String password) {
      Transaction transaction=session.beginTransaction();

        User user=session.createQuery("from User where username=:username and password=:password", User.class)
                .setParameter("username",username).setParameter("password",password).getSingleResult();
        if(user==null){
            throw new ResourceNotFoundException("incorrect user name or password");
        }
        transaction.commit();
        return user;
    }
}
