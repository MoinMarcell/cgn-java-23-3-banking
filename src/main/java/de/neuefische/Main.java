package de.neuefische;

import java.math.BigDecimal;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        BankService bankService = new BankService();
        Client max = new Client("1", "Max", "Mustermann");
        Client susi = new Client("2", "Susi", "Sorglos");
        String accountNumber = bankService.addAccount(List.of(max, susi));

        Account account = bankService.getAccount(accountNumber);
        System.out.println(account);

        bankService.transfer(accountNumber, "2", BigDecimal.valueOf(100));
        System.out.println(account);

        List<String> newAccountNumbers = bankService.split(accountNumber);
        System.out.println(newAccountNumbers);
    }
}