package com.stevelinz.sales;

import java.io.*;
import java.util.ArrayList;

public class SummaryHelper {
    public void summarizeCountry() throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader("sumtemp.txt"));

        String country = "";

        double amount = 0;

        double tax = 0;

        //Creating ArrayList to hold Sales objects

        ArrayList<Sale> salesSummer = new ArrayList<Sale>();

        //Reading Sales records one by one
        String currentLine = reader.readLine();
        String currentParse = currentLine;
        String countryCurrent = "";
        double totalAmount = 0;
        double totalTax = 0;
        int count = 0;
        String part1 ="";


        while (currentLine != null) {
            String[] saleDetail = currentLine.split(",");
            country = saleDetail[0];
            amount = Double.parseDouble(saleDetail[1]);
            tax = Double.parseDouble(saleDetail[2]);
            if(count == 0){
                countryCurrent = country;
                count++;
            }
            if(!countryCurrent.equalsIgnoreCase(saleDetail[0])){
                salesSummer.add(new Sale( country, amount, tax));
                currentLine = reader.readLine();
                countryCurrent = country;
            }
            else {
                totalAmount = totalAmount + amount;
                totalTax = totalTax + tax;
                currentLine = reader.readLine();
                currentParse = currentLine;
                String[] parts = currentParse.split(",",0);
                part1 = parts[0];
                if (!part1.equals(countryCurrent)) {
              //  if(countryCurrent.equalsIgnoreCase(saleDetail[0])){
                    salesSummer.add(new Sale(countryCurrent, totalAmount, totalTax));
                }
                if (!part1.equals(countryCurrent)) {
                    totalAmount = 0;
                    totalTax = 0;
                    countryCurrent = country;
                }
            }
        }
        BufferedWriter writer = new BufferedWriter(new FileWriter("sumReport.txt"));
        for (Sale sale : salesSummer) {
            writer.write(sale.country + "," + sale.amount + "," + sale.tax + "\n");
        }
        //Closing the resources
        reader.close();
        writer.close();
    }

}



