package com.vic.design;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DesignApplication implements CommandLineRunner {
    private static Logger logger = LoggerFactory.getLogger(DesignApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(DesignApplication.class, args);


    }

    @Override
    public void run(String... args) throws Exception {
    }
}

