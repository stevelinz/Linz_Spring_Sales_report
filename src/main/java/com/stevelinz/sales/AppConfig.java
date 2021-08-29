package com.stevelinz.sales;
import com.stevelinz.sales.iface.IRead;
import com.stevelinz.sales.iface.IReport;
import com.stevelinz.sales.iface.IShip;
import com.stevelinz.sales.impl.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.stevelinz.sales")
public class AppConfig {
    @Bean
    public IRead iRead() {
     //  return new ReadFile();
       return new ReadConsole();
    }

    @Bean
    public IReport iReport(){
     //   return new DetailedReport();
        return new SummaryReport();

    }

    @Bean
    public IShip iShip(){
     //  return new ShipRate10();
       return  new ShipRateFree();
    }
}
