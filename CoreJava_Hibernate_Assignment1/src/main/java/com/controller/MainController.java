package com.controller;

import com.enums.AccountType;
import com.enums.Status;
import com.config.HibernateConfig;
import com.model.Account;
import com.model.Customer;
import com.model.User;
import com.service.AccountService;
import com.service.AuthService;
import com.service.CustomerService;
import jakarta.persistence.NoResultException;
import org.hibernate.Session;

import java.util.Scanner;

public class MainController {
    public static void main(String[] args) {

        Session session =HibernateConfig.getSessionFactory().openSession();
        AuthService authService=new AuthService(session);
        AccountService accountService=new AccountService(session);
        System.out.println("welcome to bank management system.");
        Scanner sc=new Scanner(System.in);
        CustomerService customerService=new CustomerService(session);
        System.out.println("enter the user name: ");
        String username=sc.nextLine().trim();
        System.out.println("enter the password");
        String password=sc.nextLine().trim();
       User user= authService.verifyUser(username,password);
        System.out.println(user.getRole());
        while(true){

        System.out.println("1.add customer");
        System.out.println("2.update customer");
        System.out.println("3 delete customer");
            System.out.println("4 Get Account by id:");
        System.out.println("5.fetch all customer");
        int ch=sc.nextInt();
        if(ch==0){
            break;
        }
        switch (ch){
            case 1:
// Pass the literal values and null objects directly inside the constructor
                sc.nextLine();
                System.out.print("Enter Account Type (SAVINGS/CURRENT): ");
                String accounttypeStr = sc.nextLine();

                System.out.print("Enter Branch Name: ");
                String branchname = sc.nextLine();

                System.out.print("Enter IFSC Code: ");
                String ifsccode = sc.nextLine();

                System.out.print("Enter Initial Balance: ");
                Double balance = sc.nextDouble();

                Account account = new Account();
                account.setAccounttype(AccountType.valueOf(accounttypeStr));
                account.setStatus(Status.ACTIVE);
                account.setBranchname(branchname);
                account.setIfsccode(ifsccode);
                account.setBalance(balance);
           accountService.createAccount(account,user.getUsername());
                break;
            case 2:
                System.out.println("enter the id");
                int id= sc.nextInt();
                System.out.println("enter the details to be updated");

                System.out.print("Enter Account Type (SAVINGS/CURRENT): ");
                sc.nextLine();
            accounttypeStr = sc.nextLine();

                System.out.print("Enter Branch Name: ");
                 branchname = sc.nextLine();

                System.out.print("Enter IFSC Code: ");
                ifsccode = sc.nextLine();

                System.out.print("Enter Initial Balance: ");
               balance = sc.nextDouble();
                 account = new Account();
                account.setAccounttype(AccountType.valueOf(accounttypeStr));
                account.setStatus(Status.ACTIVE);
                account.setBranchname(branchname);
                account.setIfsccode(ifsccode);
                account.setBalance(balance);
                accountService.updateAccount(account,id);
                break;
            case 3:
                System.out.println("Enter the id:");
                id=sc.nextInt();
                try{
                    accountService.deleteAccount(id,user.getUsername());
                }catch (NoResultException e){
                    System.out.println("Invalid id");
                }
                break;
            case 4:
                System.out.println("Enter the id:");
                id=sc.nextInt();
                Account account1=accountService.getById(id);
                System.out.println(account1);
            break;

            case 5:
                accountService.getAllAccounts(username).forEach(System.out::println);
                break;
        }

        }

    }
}
