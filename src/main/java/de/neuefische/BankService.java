package de.neuefische;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BankService {
    private final List<Account> accounts;

    public BankService() {
        this.accounts = new ArrayList<>();
    }

    public String addAccount(Client owner) {
        String accountNumber = String.valueOf(accounts.size() + 1);
        Account newAccount = new Account(accountNumber, BigDecimal.ZERO, owner);
        accounts.add(newAccount);
        return accountNumber;
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
