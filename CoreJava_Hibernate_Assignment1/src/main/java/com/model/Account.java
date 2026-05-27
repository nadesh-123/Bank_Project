package com.model;

import com.enums.AccountType;
import com.enums.Status;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int accno;
    @ManyToOne
    private Customer customer;
    @ManyToOne
    private Employee employee;
    @Enumerated(EnumType.STRING)
    private AccountType accounttype;
    private String branchname;
    private String ifsccode;
    private Double balance;
    @CreationTimestamp
    private Instant createdAt;
    @UpdateTimestamp
    private Instant updatedAt;
    @Enumerated(EnumType.STRING)
    private Status status;
    // Parameterized constructor matching your exact initialization layout
    public Account(AccountType accounttype, String branchname, String ifsccode, double balance, Status status) {
        this.customer = null; // Explicitly setting foreign keys to null
        this.employee = null;
        this.accounttype = accounttype;
        this.branchname = branchname;
        this.ifsccode = ifsccode;
        this.balance = balance;
        this.status = status;
    }

    public int getAccno() {
        return accno;
    }

    public void setAccno(int accno) {
        this.accno = accno;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public AccountType getAccounttype() {
        return accounttype;
    }

    public void setAccounttype(AccountType accounttype) {
        this.accounttype = accounttype;
    }

    public String getBranchname() {
        return branchname;
    }

    public void setBranchname(String branchname) {
        this.branchname = branchname;
    }

    public String getIfsccode() {
        return ifsccode;
    }

    public void setIfsccode(String ifsccode) {
        this.ifsccode = ifsccode;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accno=" + accno +
                ", customer=" + customer +
                ", employee=" + employee +
                ", accounttype=" + accounttype +
                ", branchname='" + branchname + '\'' +
                ", ifsccode='" + ifsccode + '\'' +
                ", balance=" + balance +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", status=" + status +
                '}';
    }

    public Account() {
    }
}
