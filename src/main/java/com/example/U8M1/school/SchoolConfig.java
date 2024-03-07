package com.example.U8M1.school;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SchoolConfig {
    @Bean
    CommandLineRunner commandLineRunnerSchool(SchoolRepository repository){
        return args -> {
             School abc = new School(
                    "Abstract Basic Concentration (ABC)",
                    "We help grow you not your problems",
                    "(662)-123-4563"
            );

             School bankofusa = new School(
                    "Bank of USA",
                    "We hold what you cant",
                    "(662)-103-1039"
            );
            repository.saveAll(List.of(abc, bankofusa));
        };
    }
}
