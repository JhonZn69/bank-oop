package org.ies.bank.components;

import org.ies.bank.model.Account;
import org.ies.bank.model.Bank;

public class BankApp2 {
    private final BankReader bankReader;

    public BankApp2(BankReader bankReader) {
        this.bankReader = bankReader;
    }

    public void run() {
        Bank bank = bankReader.read();
        Account account1 = bank.findAccount("ES0001");
        if (account1 != null){
            account1.deposit(500);
        }else{
            System.out.println("No existe la cuenta");
        }
        Account account2 = bank.findAccount("ES0002");
        if (account2 != null){
            account2.takeOut(30);
        } else {
            System.out.println("No existe la cuenta");
        }
        account1.showInfo();
        account2.showInfo();
        bank.transferMoney(account1.getIban(), account2.getIban(), 500);
    }
}