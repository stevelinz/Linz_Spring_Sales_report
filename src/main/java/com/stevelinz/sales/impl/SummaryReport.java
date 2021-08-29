package com.stevelinz.sales.impl;

import com.stevelinz.sales.RateShipCalc;
import com.stevelinz.sales.Sale;
import com.stevelinz.sales.SortSales;
import com.stevelinz.sales.SummaryHelper;
import com.stevelinz.sales.iface.IReport;

import java.io.*;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class SummaryReport implements IReport {
    @Override
    public void reportType() throws IOException {

        SortSales sortSales = new SortSales();
        sortSales.sortCountry();
        SummaryHelper summaryHelper = new SummaryHelper();
        summaryHelper.summarizeCountry();

            try {
                File f = new File("sumReport.txt");
                Scanner sc = new Scanner(f);

                List<Sale> sales = new ArrayList<Sale>();

                String country = "";
                RateShipCalc rateShipCalc = new RateShipCalc();

                NumberFormat formatter = NumberFormat.getCurrencyInstance();
                double amount = 0.0;
                double tax = 0.0;
                System.out.println("SALES SUMMARY REPORT");
                System.out.printf(" %-20s %-10s %-10s %-10s  ", "Country", "AMOUNT", "TAX", "SHIPPING");
                System.out.println();
                while (sc.hasNextLine()) {
                    String line = sc.nextLine();
                    String[] details = line.split(",");
                    country = details[0];
                    amount = Double.parseDouble(details[1]);
                    tax = Double.parseDouble(details[2]);

                    Sale s = new Sale(country, amount, tax);
                    Double shipCalc = amount / rateShipCalc.shipRate();
                    String note = "";
                    if(rateShipCalc.shipRate() == 0) note = " ~~~ FREE SHIPPING ~~~ "; ;
                    sales.add(s);
                    System.out.printf(" %-20s %-10s %-10s %-10s %-1s", country,
                            formatter.format(amount), formatter.format(tax), formatter.format(shipCalc), note);
                    System.out.println();
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

    }




