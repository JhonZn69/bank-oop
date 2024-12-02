package org.ies.bank.components;

import org.ies.bank.model.Account;
import org.ies.bank.model.Customer;

import java.util.Locale;
import java.util.Scanner;

public class AccountReader {
    private final Scanner scanner;
    private final CustomerReader customerReader;

    public AccountReader(Scanner scanner, CustomerReader customerReader) {
        this.scanner = scanner;
        this.customerReader = customerReader;
    }

    public Account read() {
        System.out.println("IBAN");
        String iban = scanner.nextLine();

        System.out.println("Saldo");
        double balance = scanner.nextDouble();

        System.out.println("Cliente");
        Customer cliente = customerReader.read();
        return new Account(
                iban,
                balance,
                cliente
        );
    }
}