package com.stevelinz.sales.impl;

import com.stevelinz.sales.iface.IShip;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ShipRateFree implements IShip {
    public ShipRateFree() {
    }

    @Override
    public void shipFlatRate() throws IOException {

        File file = new File("shipRate.txt");
        FileWriter fr = null;
        {
            try {
                fr = new FileWriter(file, false);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        BufferedWriter writer = new BufferedWriter(fr);
        writer.write("0");
        writer.close();
        fr.close();
    }

}

