package com.stevelinz.sales.impl;

import com.stevelinz.sales.iface.IRead;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile implements IRead {

    public void fileDisplay() throws IOException {
        // variable declaration
        int ch = 0;

        // check if File exists or not
        FileReader fr=null;
        try
        {
            fr = new FileReader("sales.txt");
        }
        catch (FileNotFoundException fe)
        {
            System.out.println("File not found");
        }

        // read from FileReader till the end of file
        while (true) {
            try {
                if ((ch = fr.read()) == -1) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
              System.out.print((char)ch);
        }
        System.out.println();
        // close the file
        fr.close();
    }

    @Override
    public void readType() {

    }
}
