package com.stevelinz.sales;

import com.stevelinz.sales.iface.IRead;
import com.stevelinz.sales.iface.IReport;
import com.stevelinz.sales.iface.IShip;
import com.stevelinz.sales.impl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component
class SalesReportHub {
    private IRead iRead;
    private IReport iReport;
    private IShip iShip;
    
    private List<String> sales = new ArrayList<String>();

    @Autowired
    public SalesReportHub(IRead iRead, IReport iReport, IShip iShip){
        this.iRead = iRead;
        this.iReport = iReport;
        this.iShip = iShip;
    }

    public void play() throws IOException {

        addShipping();
        addReport();
        addRead();
    }
        private void addShipping () throws IOException {
        iShip.shipFlatRate();
        }
        private void addRead(){
        iRead.readType();
        }
        private void addReport() throws IOException {
        iReport.reportType();
        }
    }










