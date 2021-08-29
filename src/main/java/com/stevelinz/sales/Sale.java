package com.stevelinz.sales;

public class Sale {

    public String customer;
    public String country;
    public double amount;
    public double tax;
    public double ship;


    public Sale(String customer, String country, double amount, double tax) {
        this.customer = customer;
        this.country = country;
        this.amount = amount;
        this.tax = tax;
    }

    public Sale(String customer, String country, double amount, double tax, double ship) {
        this.customer = customer;
        this.country = country;
        this.amount = amount;
        this.tax = tax;
        this.ship = ship;
    }

    public Sale(String country, double amount, double tax) {
        this.country = country;
        this.amount = amount;
        this.tax = tax;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public double getShip() {
        return ship;
    }

    public void setShip(double ship) {
        this.ship = ship;
    }


}

