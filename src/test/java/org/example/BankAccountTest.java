package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {

    @Test
    public void testConstructorInitializesAccountWithNameAndBalance() {
        BankAccount account = new BankAccount("John Doe", 1000.0);
        assertEquals("John Doe", account.getAccountHolderName());
        assertEquals(1000.0, account.getBalance(), 0.001);
        assertNotNull(account.getAccountId());
    }

    @Test
    public void testConstructorGeneratesUniqueAccountId() {
        BankAccount account1 = new BankAccount("Alice", 500.0);
        BankAccount account2 = new BankAccount("Bob", 500.0);
        assertFalse(account1.getAccountId().equals(account2.getAccountId()));
    }

    @Test
    public void testDepositIncreasesBalance() {
        BankAccount account = new BankAccount("Jane Smith", 500.0);
        account.deposit(200.0);
        assertEquals(700.0, account.getBalance(), 0.001);
    }

    @Test
    public void testMultipleDeposits() {
        BankAccount account = new BankAccount("Test User", 100.0);
        account.deposit(50.0);
        account.deposit(75.0);
        account.deposit(25.0);
        assertEquals(250.0, account.getBalance(), 0.001);
    }

    @Test
    public void testWithdrawDecreasesBalance() {
        BankAccount account = new BankAccount("John Doe", 1000.0);
        account.withdraw(300.0);
        assertEquals(700.0, account.getBalance(), 0.001);
    }

    @Test
    public void testMultipleWithdrawals() {
        BankAccount account = new BankAccount("Test User", 1000.0);
        account.withdraw(100.0);
        account.withdraw(200.0);
        account.withdraw(50.0);
        assertEquals(650.0, account.getBalance(), 0.001);
    }

    @Test
    public void testDepositAndWithdrawCombination() {
        BankAccount account = new BankAccount("Mixed Operations", 500.0);
        account.deposit(200.0);
        account.withdraw(100.0);
        account.deposit(50.0);
        account.withdraw(150.0);
        assertEquals(500.0, account.getBalance(), 0.001);
    }

    @Test
    public void testGetBalanceReturnsCurrentBalance() {
        BankAccount account = new BankAccount("Balance Test", 750.0);
        assertEquals(750.0, account.getBalance(), 0.001);
    }

    @Test
    public void testGetAccountHolderNameReturnsCorrectName() {
        BankAccount account = new BankAccount("Alice Johnson", 1000.0);
        assertEquals("Alice Johnson", account.getAccountHolderName());
    }

    @Test
    public void testZeroInitialBalance() {
        BankAccount account = new BankAccount("Zero Balance", 0.0);
        assertEquals(0.0, account.getBalance(), 0.001);
    }

    @Test
    public void testDepositZeroAmount() {
        BankAccount account = new BankAccount("Test", 100.0);
        account.deposit(0.0);
        assertEquals(100.0, account.getBalance(), 0.001);
    }

    @Test
    public void testWithdrawZeroAmount() {
        BankAccount account = new BankAccount("Test", 100.0);
        account.withdraw(0.0);
        assertEquals(100.0, account.getBalance(), 0.001);
    }
}