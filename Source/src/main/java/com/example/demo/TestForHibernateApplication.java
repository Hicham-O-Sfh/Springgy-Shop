package com.example.demo;

import com.example.demo.controllers.ProduitsController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.io.File;

@SpringBootApplication
//@ComponentScan({"demo", "controllers"})
public class TestForHibernateApplication {

    public static void main(String[] args) {
        new File(ProduitsController.uploadDirectory).mkdir();
        SpringApplication.run(TestForHibernateApplication.class, args);
    }

}
