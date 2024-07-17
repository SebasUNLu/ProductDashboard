package com.example.productDashboard;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class EnvConfig {

    public static void loadEnv(){
        try {
            List<String> lines = Files.readAllLines(Paths.get(".env"));
            System.out.println("Env variables");
            System.out.println(lines);
            for(String line: lines){
                if(line.trim().isEmpty() || line.startsWith("#")){
                    continue;
                }
                String[] parts = line.split("=", 2);
                if(parts.length == 2){
                    System.setProperty(parts[0].trim(), parts[1].trim());
                }

            }
        } catch (IOException e){
            throw new RuntimeException("Failed to load .env file", e);
        }
    }

}
