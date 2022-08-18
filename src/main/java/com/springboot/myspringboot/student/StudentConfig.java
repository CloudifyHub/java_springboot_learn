package com.springboot.myspringboot.student;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static java.util.Calendar.AUGUST;
import static java.util.Calendar.getAvailableLocales;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner (StudentRepository repository) {
        return args -> {
             Student mariam  = new Student(
                    "Mariam",
                    "mariam@java.com",
                    LocalDate.of(1995, AUGUST, 18)

            );

            Student richmond  = new Student(
                    "Richmond",
                    "richmond@java.com",
                    LocalDate.of(1966, AUGUST, 18)
            );

            repository.saveAll(
                    List.of(mariam, richmond)
            );
        };
    }

}
