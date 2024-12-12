package org.ies.bank.components;

import org.ies.bank.model.Account;
import org.ies.bank.model.Bank;

public class BankApp4 {
    private final BankReader bankReader;

    public BankApp4(BankReader bankReader) {
        this.bankReader = bankReader;
    }
    public void run(){
        Bank bank = bankReader.read();
        Account account1 = bank.findAccount("ES0001");
        if (account1 != null){
            account1.showInfo();
            bank.transferMoney("ES0001", "ES0002", account1.getBalance());
            bank.printAccount();
        } else {
            System.out.println("Error, no existe la cuenta");
        }
    }
}