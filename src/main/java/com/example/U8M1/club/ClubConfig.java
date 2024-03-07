package com.example.U8M1.club;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ClubConfig {
    @Bean
    CommandLineRunner commandLineRunnerClub(ClubRepository repository){
        return args -> {
            Club red = new Club(
                    "accountants",
                    "adrian.yngmex@gmail.com",
                    "List of members"
            );

            Club blue = new Club(
                    "designers",
                    "maddieGross@gmail.com",
                    "list of members"
            );
            repository.saveAll(List.of(red, blue));
        };
    }
}
