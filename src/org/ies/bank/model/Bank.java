package org.ies.bank.model;

import java.util.Arrays;
import java.util.Objects;

public class Bank {
    private String name;
    private Account[] accounts;

    public Bank(String name, Account[] accounts) {
        this.name = name;
        this.accounts = accounts;
    }

    public void showAccounts(){
        for (Account account : accounts ){
            System.out.println("IBAN " + account.getIban() +
                    "Saldo " + account.getBalance() +
                    "NIF del cliente " + account.getCustomer().getNif());
        }
    }

    public Account findAccount(String iban) {
        for (Account account : accounts){
            if (account.getIban().equals(iban)){
                return account;
            }
        }
        return null;
    }

    public void showAccount(String nif){
        for (Account account : accounts){
            if (account.getCustomer().getNif().equals(nif)) {
                System.out.println("IBAN " + account.getIban() + "Saldo " + account.getBalance());
            }
        }
    }

    public void addBalance (String iban , double cantMoney) {
        Account account = findAccount(iban);
        if (account.getIban().equals(iban)) {
            account.setBalance(account.getBalance() + cantMoney);
        } else {
            System.out.println("No se encuentra la cuenta");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Account[] getAccounts() {
        return accounts;
    }

    public void setAccounts(Account[] accounts) {
        this.accounts = accounts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bank bank = (Bank) o;
        return Objects.equals(name, bank.name) && Objects.deepEquals(accounts, bank.accounts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, Arrays.hashCode(accounts));
    }

    @Override
    public String toString() {
        return "Bank{" +
                "name='" + name + '\'' +
                ", accounts=" + Arrays.toString(accounts) +
                '}';
    }
}
