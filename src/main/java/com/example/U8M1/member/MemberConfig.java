package com.example.U8M1.member;


import org.springframework.boot.*;
import org.springframework.context.annotation.*;

import java.util.List;

@Configuration
public class MemberConfig {
    @Bean
    CommandLineRunner commandLineRunner(MemberRepository repository){
        return args -> {
            Member adrian = new Member(
                    "Adrian",
                    "Software Engineer",
                    "adrian.yngmex@gmail.com",
                    "(662)-123-4563"
            );

            Member madeline = new Member(
                    "Madeline",
                    "Broker",
                    "maddieGross@gmail.com",
                    "(662)-103-1039"
            );
            repository.saveAll(List.of(adrian, madeline));
        };
    }
}
