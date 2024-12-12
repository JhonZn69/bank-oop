package org.ies.bank.model;

import java.util.Objects;

public class Account {
    private String iban;
    private Double balance;
    private Customer cliente;

    public Account(String iban, Double saldo, Customer cliente) {
        this.iban = iban;
        this.balance = saldo;
        this.cliente = cliente;
    }
    public void showInfo(){
        System.out.println("IBAN: " + getIban());
        System.out.println("Saldo: " + getBalance());
        System.out.println("NIF del cliente: " + cliente.getNif());
    }
    public void deposit(double amount) {
        balance += amount;
    }
    public void takeOut(double amount) {
        balance -= amount;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Customer getCliente() {
        return cliente;
    }

    public void setCliente(Customer cliente) {
        this.cliente = cliente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(iban, account.iban) && Objects.equals(balance, account.balance) && Objects.equals(cliente, account.cliente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(iban, balance, cliente);
    }

    @Override
    public String toString() {
        return "Account{" +
                "iban='" + iban + '\'' +
                ", saldo=" + balance +
                ", cliente=" + cliente +
                '}';
    }
}
