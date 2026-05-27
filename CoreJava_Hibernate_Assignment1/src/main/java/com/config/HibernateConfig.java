package com.config;

import com.model.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.dialect.MySQLDialect;

public class HibernateConfig {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if(sessionFactory==null){
            Configuration configuration=new Configuration();
            configuration.setProperty("hibernate.connection.url","jdbc:mysql://localhost:3306/bank_db1?createDatabaseIfNotExist=true");
            configuration.setProperty("hibernate.connection.user","root");
            configuration.setProperty("hibernate.connection.password","Nadesh@123");
           // configuration.setProperty("hibernate.connection.driver_class","java.mysql.cj.jdbc.Driver");
           configuration.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
            configuration.setProperty("hibernate.dialect","org.hibernate.dialect.MySQLDialect");
            configuration.setProperty("hibernate.hbm2ddl.auto","update");
            //configuration.setProperty("hibernate.hbm2ddl.auto", "update");
            configuration.addAnnotatedClass(Customer.class);
            configuration.addAnnotatedClass(User.class);
            configuration.addAnnotatedClass(Account.class);
            configuration.addAnnotatedClass(Transaction.class);
            configuration.addAnnotatedClass(Employee.class);
           return configuration.buildSessionFactory();
        }
        return sessionFactory;
    }
}
