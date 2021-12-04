package com.example.titanic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class TitanicApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(TitanicApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Logic.main();
    }
}
