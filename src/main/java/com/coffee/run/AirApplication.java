package com.coffee.run;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class AirApplication {
    public static void main(String[] args) {
        SpringApplication.run(AirApplication.class,args);


        AnnotationConfigApplicationContext c = new AnnotationConfigApplicationContext();
    }







}
