package org.ies.bank.components;

import org.ies.bank.model.Account;
import org.ies.bank.model.Bank;


import java.util.Scanner;

public class BankApp {
    private final Scanner scanner;
    private final BankReader bankReader;

    public BankApp(Scanner scanner, BankReader bankReader) {
        this.scanner = scanner;
        this.bankReader = bankReader;
    }
    private int chooseOption(){
        System.out.println("Elige una opcion");
        System.out.println("1. Mostrar las cuentas del banco");
        System.out.println("2. Mostrar los datos de una cuenta");
        System.out.println("3. Mostrar los datos de las cuentas de un cliente");
        System.out.println("4. Ingresar dinero en cuenta");
        System.out.println("5. Sacar dinero de una cuenta");
        System.out.println("6. Contar cuentas de cliente");
        System.out.println("7. Mostrar el cliente de una cuenta");
        System.out.println("8. Realizar una transferencia");
        System.out.println("9. Salir");
        int option = scanner.nextInt();
        scanner.nextLine();
        return option;
    }

    public void run() {
        int option;
        var bank = bankReader.read();
        do {
            option = chooseOption();
            if (option == 1) {
                bank.printAccount();
            } else if (option == 2) {
                System.out.println("Introduce el IBAN de la cuenta");
                String iban = scanner.nextLine();
                var findAccount = bank.findAccount(iban);
                if (findAccount != null) {
                    bank.showAccountIban(iban);
                } else {
                    System.out.println("No existe la cuenta");
                }
            } else if (option == 3) {
                System.out.println("Introduce el NIF del cliente asociado a la cuenta");
                String nif = scanner.nextLine();
                bank.showAccountNif(nif);
            } else if (option == 4) {
                System.out.println("Introduce el IBAN de la cuenta a la que desea ingresar el dinero");
                String iban = scanner.nextLine();
                System.out.println("Ingrese la cantidad de dinero que desea ingresar");
                double money = scanner.nextDouble();
                scanner.nextLine();
                var findAccount = bank.findAccount(iban);
                if (findAccount != null) {
                    bank.addMoney(iban, money);
                    bank.showAccountIban(iban);
                } else {
                    System.out.println("No existe la cuenta");
                }
            } else if (option == 5) {
                System.out.println("Introduce el IBAN de la cuenta a la que desea retirar el dinero");
                String iban = scanner.nextLine();
                System.out.println("Ingrese la cantidad de dinero que desea retirar");
                double money = scanner.nextDouble();
                scanner.nextLine();
                var findAccount = bank.findAccount(iban);
                if (findAccount != null) {
                    if (findAccount.getBalance() < money) {
                        System.out.println("Saldo insuficiente");
                    } else {
                        bank.takeOutMoney(iban, money);
                        bank.showAccountIban(iban);
                    }
                } else {
                    System.out.println("No existe la cuenta");
                }
            } else if (option == 6) {
                System.out.println("Introduce el NIF del cliente");
                String nif = scanner.nextLine();
                bank.showCantAccounts(nif);
            } else if (option == 7) {
                System.out.println("Introduce el IBAN de la cuenta");
                String iban = scanner.nextLine();
                bank.showCustomerIban(iban);
            } else if (option == 8) {
                System.out.println("Ingrese el IBAN de la cuenta de origen");
                String iban1 = scanner.nextLine();
                System.out.println("Ingrese la cantidad de dinero que desea transferir");
                double amount = scanner.nextDouble();
                scanner.nextLine();
                System.out.println("Ingrese el IBAN de la cuenta de destino");
                String iban2 = scanner.nextLine();
                bank.transferMoney(iban1, iban2, amount);
            } else if (option == 9) {
                System.out.println("Saliendo...");
            } else {
                System.out.println("Opcion invalida");
            }
        }while (option != 9) ;
    }
}

