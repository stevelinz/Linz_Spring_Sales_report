package com.stevelinz.sales.impl;

import com.stevelinz.sales.iface.IRead;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadConsole implements IRead {


    @Override
    public void readType() {

        List<String> sales = new ArrayList<>();
        File file = new File("sales.txt");
        FileWriter fr = null;
        {
            try {
                fr = new FileWriter(file, true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        BufferedWriter writer = new BufferedWriter(fr);

            System.out.println("\nAdd new Sale.");
            Scanner scanner = new Scanner(System.in);
            System.out.println("ENTER CUSTOMER: ");
            String customer = scanner.nextLine();
            System.out.println("ENTER COUNTRY: ");
            String country = scanner.nextLine();
            System.out.println("ENTER AMOUNT: ");
            String amount = scanner.nextLine();
            System.out.println("ENTER TAX: ");
            String tax = scanner.nextLine();
            sales.add(customer + " " + country + " " +
                    amount + " " + tax);
            System.out.println("Enter [d]one if done +" +
                    " or [c]ontinue to continue.");
            String select = scanner.nextLine();
            if (select.equalsIgnoreCase("d")) {
                System.out.println("Input complete.");
                try {
                    writer.write(customer + "," + country + "," + amount + "," + tax + "\n");
                    writer.close();
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println(customer + "," + country + "," + amount + "," + tax);
                scanner.close();
            } else {

                while (select != "d") {
                    System.out.println("ENTER CUSTOMER: ");
                    customer = scanner.nextLine();
                    System.out.println("ENTER COUNTRY: ");
                    country = scanner.nextLine();
                    System.out.println("ENTER AMOUNT: ");
                    amount = scanner.nextLine();
                    System.out.println("ENTER TAX: ");
                    tax = scanner.nextLine();
                    sales.add(customer + "," + country + "," + amount + "," + tax);

                    System.out.println("Enter [d]one if done +" +
                            " or [c]ontinue to continue.");
                    select = scanner.nextLine();
                    if (select.equalsIgnoreCase("d")) {
                        System.out.println("Input complete.");
                        try {
                            writer.write(customer + "," + country + "," + amount + "," + tax + "\n");
                            writer.close();
                            fr.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        System.out.println(customer + "," + country + "," + amount + "," + tax);
                        break;
                    }
                }
                scanner.close();
            }
        }
    }









