package com.stevelinz.sales;

import java.io.*;
import java.util.ArrayList;

public class SortSales {
    public void sortCountry() throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader("sales.txt"));

        String customer = "";
        String country = "";
        double amount = 0;
        double tax = 0;

        boolean change = false;

        ArrayList<Sale> salesRecords = new ArrayList<Sale>();

        String currentLine = reader.readLine();

        while (currentLine != null) {
            String[] saleDetail = currentLine.split(",");

            customer = saleDetail[0];
            country = saleDetail[1];
            amount = Double.parseDouble(saleDetail[2]);
            tax = Double.parseDouble(saleDetail[3]);


            salesRecords.add(new Sale(customer, country, amount, tax));

            currentLine = reader.readLine();
        }

        salesRecords.sort(new CountryCompare().reversed());

        BufferedWriter writer = new BufferedWriter(new FileWriter("sumtemp.txt"));

        for (Sale sale : salesRecords) {
            writer.write(sale.country + "," + sale.amount + "," + sale.tax);

            writer.newLine();
        }
        reader.close();
        writer.close();

    }

}

