package com.stevelinz.sales;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

public class MyApp {
    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AppConfig.class);
        context.refresh();
        ((SalesReportHub)context.getBean("salesReportHub")).play();
    }
}