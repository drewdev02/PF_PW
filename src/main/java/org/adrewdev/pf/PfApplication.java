package org.adrewdev.pf;

import org.adrewdev.pf.utilis.GenerateData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class PfApplication implements CommandLineRunner {
    @Autowired
    GenerateData generateData;

    public static void main(String[] args) {
        SpringApplication.run(PfApplication.class, args);
    }

    @Override
    public void run(String... args) {
        generateData.run();
    }
}
