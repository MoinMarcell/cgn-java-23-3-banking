package de.neuefische;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

public class Account {
    private String accountNumber;
    private BigDecimal balance;
    private List<Client> owners;

    public Account(String accountNumber, BigDecimal balance, List<Client> owners) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.owners = owners;
    }

    public void deposit(BigDecimal amount) {
        balance = balance.add(amount);
    }

    public void withdraw(BigDecimal amount) {
        if (balance.compareTo(amount) > 0 && amount.compareTo(BigDecimal.ZERO) > 0) {
            balance = balance.subtract(amount);
        }
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public List<Client> getOwners() {
        return owners;
    }

    public void setOwners(List<Client> owners) {
        this.owners = owners;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(accountNumber, account.accountNumber) && Objects.equals(balance, account.balance) && Objects.equals(owners, account.owners);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountNumber, balance, owners);
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountNumber='" + accountNumber + '\'' +
                ", balance=" + balance +
                ", owners=" + owners +
                '}';
    }
}
