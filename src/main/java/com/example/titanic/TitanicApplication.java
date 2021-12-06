package com.example.titanic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

@SpringBootApplication
public class TitanicApplication implements CommandLineRunner {

    @Autowired
    private Logic logic;

    public static void main(String[] args) {
        SpringApplication.run(TitanicApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        logic.main();
    }

}
