package com.example.hexagonal_rve;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class HexagonalRveApplication {

  public static void main(String[] args) {
    SpringApplication.run(HexagonalRveApplication.class, args);
  }

}
