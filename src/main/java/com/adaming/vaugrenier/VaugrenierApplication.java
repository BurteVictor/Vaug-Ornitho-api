package com.adaming.vaugrenier;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VaugrenierApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(VaugrenierApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
