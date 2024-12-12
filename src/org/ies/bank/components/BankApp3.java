package org.ies.bank.components;

import org.ies.bank.model.Bank;

import java.util.Scanner;

public class BankApp3 {
    private final BankReader bankReader;

    public BankApp3(BankReader bankReader) {
        this.bankReader = bankReader;
    }

    public void run(){
        Bank bank = bankReader.read();
        bank.printAccount();
        bank.takeOutMoney("ES0003", 50);
        bank.showAccountNif("000X");
        bank.addMoney("ES004", 300);
        bank.showCustomerIban("ES0001");
    }
}