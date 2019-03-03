package com.vic.design;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DesignApplication {
    private static Logger logger = LoggerFactory.getLogger(DesignApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(DesignApplication.class, args);
        logger.info("11111111111");
        logger.error("2222222222");
        logger.debug("3333333333");

    }

}

