package com.bibliotecaDev.CRUD_library;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.bibliotecaDev.CRUD_library")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}

