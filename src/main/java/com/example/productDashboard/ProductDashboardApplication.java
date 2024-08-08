package com.example.productDashboard;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductDashboardApplication {

    public static void main(String[] args) {
        Dotenv dotenv = Dotenv.load();
        SpringApplication.run(ProductDashboardApplication.class, args);
        System.out.println("Ejecutando correctamente");
    }

}
