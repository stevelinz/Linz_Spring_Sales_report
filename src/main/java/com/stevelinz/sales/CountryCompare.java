package com.stevelinz.sales;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;

public class CountryCompare implements Comparator<Sale> {
        @Override
        public int compare(Sale s1, Sale s2) {
            return s1.country.compareTo(s2.country);
        }
    }



