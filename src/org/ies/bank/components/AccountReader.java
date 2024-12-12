package org.ies.bank.components;

import org.ies.bank.model.Account;
import org.ies.bank.model.Customer;

import java.util.Scanner;

public class AccountReader {
    private final Scanner scanner;
    private final CustomerReader customerReader;

    public AccountReader(Scanner scanner, CustomerReader customerReader) {
        this.scanner = scanner;
        this.customerReader = customerReader;
    }

    public Account read() {
        System.out.println("Introduce los datos de la cuenta bancaria");
        System.out.println("Codigo  IBAN: ");
        String iban = scanner.nextLine();

        System.out.println("Saldo de la cuenta");
        Double balance = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Nombre del cliente: ");
        scanner.nextLine();
        Customer cliente = customerReader.read();


        return new Account(
                iban,
                balance,
                cliente
        );
    }
}

