package de.neuefische;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class BankService {
    private final List<Account> accounts;

    public BankService() {
        this.accounts = new ArrayList<>();
    }

    public String addAccount(List<Client> owners) {
        String accountNumber = String.valueOf(accounts.size() + 1);
        Account newAccount = new Account(accountNumber, BigDecimal.ZERO, owners);
        accounts.add(newAccount);
        return accountNumber;
    }

    public List<String> split(String accountNumber) {
        Account account = getAccount(accountNumber);
        List<Client> owners = account.getOwners();
        BigDecimal balance = account.getBalance();
        BigDecimal splitBalance = balance.divide(BigDecimal.valueOf(owners.size()), 2, RoundingMode.HALF_UP);
        List<String> newAccountNumbers = new ArrayList<>();
        for (Client owner : owners) {
            String newAccountNumber = addAccount(List.of(owner));
            Account newAccount = getAccount(newAccountNumber);
            newAccount.deposit(splitBalance);
            newAccountNumbers.add(newAccountNumber);
        }
        return newAccountNumbers;
    }

    public void transfer(String fromAccountNumber, String toAccountNumber, BigDecimal amount) {
        Account fromAccount = getAccount(fromAccountNumber);
        Account toAccount = getAccount(toAccountNumber);
        if (fromAccount != null && toAccount != null) {
            fromAccount.withdraw(amount);
            toAccount.deposit(amount);
        }
    }

    public Account getAccount(String accountNumber) {
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }
}
