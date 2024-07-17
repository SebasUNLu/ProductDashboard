package com.example.productDashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductDashboardApplication {

    public static void main(String[] args) {
        EnvConfig.loadEnv(); // Carga variables de entorno
        SpringApplication.run(ProductDashboardApplication.class, args);
        System.out.println("Ejecutando correctamente");
    }

}
