package org.example;

import java.util.UUID;

/**
 * BankAccount class for managing bank account operations
 */
public class BankAccount {
    private String accountId;
    private String accountHolderName;
    private double balance;

    /**
     * Constructor to initialise account
     */
    public BankAccount(String accountHolderName, double initialBalance)
    {
        this.accountId = UUID.randomUUID().toString();
        this.accountHolderName = accountHolderName;
        this.balance = initialBalance;
    }

    /**
     * Adds amount to balance
     */
    public void deposit(double amount)
    {
        this.balance += amount;
    }

    /**
     * Subtracts amount from balance
     */
    public void withdraw(double amount)
    {
        this.balance -= amount;
    }

    /**
     * Returns current balance
     */
    public double getBalance()
    {
        return balance;
    }

    /**
     * Returns account holder name
     */
    public String getAccountHolderName()
    {
        return accountHolderName;
    }

    /**
     * Returns account ID
     */
    public String getAccountId()
    {
        return accountId;
    }
}
