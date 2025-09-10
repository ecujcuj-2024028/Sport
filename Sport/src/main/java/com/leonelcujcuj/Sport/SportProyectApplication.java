package com.leonelcujcuj.Sport;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import java.util.InputMismatchException;
import java.util.Scanner;

@SpringBootApplication
public class SportProyectApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SportProyectApplication.class, args);
    }

    @Override
    public void run(String... args) {
        System.out.println("Api funcionando");
    }
}
