package org.example;

public class App {
    public static void main(String[] args)
    {
        BankAccount account1 = new BankAccount("Amina", 0.0);
        System.out.println("Account created for: " + account1.getAccountHolderName());
        System.out.println("Account ID: " + account1.getAccountId());
        System.out.println("Initial balance: $" + account1.getBalance());

        account1.deposit(100.0);
        System.out.println("Balance after deposit: $" + account1.getBalance());

        account1.withdraw(50.0);
        System.out.println("Balance after withdrawal: $" + account1.getBalance());

    }
}