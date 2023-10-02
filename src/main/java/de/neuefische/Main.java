package de.neuefische;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        BankService bankService = new BankService();
        Client max = new Client("1", "Max", "Mustermann");
        Client susi = new Client("2", "Susi", "Sorglos");
        String accountNumberMax = bankService.addAccount(max);
        String accountNumberSusi = bankService.addAccount(susi);

        bankService.transfer(accountNumberMax, accountNumberSusi, BigDecimal.valueOf(100));

        System.out.println("Max: " + bankService.getAccount(accountNumberMax).getBalance());
        System.out.println("Susi: " + bankService.getAccount(accountNumberSusi).getBalance());
    }
}