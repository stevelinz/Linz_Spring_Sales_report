package com.stevelinz.sales;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RateShipCalc {
 public double shipRate() {

        double rate = 0;
        File file = new File("shipRate.txt");
        if (!file.exists()) {
            System.out.println("The file shipRate.txt is not found.");
            System.exit(0);
        }
        Scanner inputFile = null;
        try {
            inputFile = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (inputFile.hasNext()) {
            rate = inputFile.nextDouble();
        }
        inputFile.close();
        return rate ;

    }
}
