package org.ies.bank.model;

import java.util.Objects;

public class Customer {
    private String nif;
    private String name;
    private String surname;

    public Customer(String nif, String name, String surname) {
        this.nif = nif;
        this.name = name;
        this.surname = surname;
    }
    public void showInfo(){
        System.out.println("NIF: " + getNif());
        System.out.println("Nombre: " + getName());
        System.out.println("Apellido: " + getSurname());
        System.out.println();
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(nif, customer.nif) && Objects.equals(name, customer.name) && Objects.equals(surname, customer.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nif, name, surname);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "nif='" + nif + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
