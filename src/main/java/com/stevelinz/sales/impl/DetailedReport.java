package com.stevelinz.sales.impl;
import com.stevelinz.sales.RateShipCalc;
import com.stevelinz.sales.Sale;
import com.stevelinz.sales.iface.IReport;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DetailedReport implements IReport {
    @Override
    public void reportType() {

        try {
            File f = new File("sales.txt");
            Scanner sc = new Scanner(f);

            List<Sale> sales = new ArrayList<Sale>();

            String customer = "";
            String country = "";

            RateShipCalc rateShipCalc = new RateShipCalc();

            NumberFormat formatter = NumberFormat.getCurrencyInstance();
            double amount = 0.0;
            double tax = 0.0;
            System.out.println("SALES DETAIL REPORT");
            System.out.printf("%-30s %-20s %-10s %-10s %-10s", "Customer", "Country", "AMOUNT", "TAX", "SHIPPING");
            System.out.println();
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] details = line.split(",");
                customer = details[0];
                country = details[1];
                amount = Double.parseDouble(details[2]);
                tax = Double.parseDouble(details[3]);

                Sale s = new Sale(customer, country, amount, tax);
                sales.add(s);
                System.out.printf("%-30s %-20s %-10s %-10s %-10s", customer, country,
                        formatter.format(amount), formatter.format(tax), formatter.format(rateShipCalc.shipRate()));
                System.out.println();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}


