package com.assigment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class AssigmentApplication {

  public static void main(String[] args) {
    SpringApplication.run(AssigmentApplication.class, args);
  }
}
