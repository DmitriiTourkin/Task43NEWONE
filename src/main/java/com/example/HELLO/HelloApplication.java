package com.example.HELLO;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class HelloApplication extends SpringBootServletInitializer {
    public HelloApplication() {
    }

    public static void main(String[] args) {
        SpringApplication.run(HelloApplication.class, args);
    }
}