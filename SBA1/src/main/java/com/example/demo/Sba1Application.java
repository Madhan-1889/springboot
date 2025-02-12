package com.example.demo;

import java.util.NoSuchElementException;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Sba1Application {

    public static void main(String[] args) {
        SpringApplication.run(Sba1Application.class, args);
    }

    @Bean
    CommandLineRunner runner(PersonRepository repository) {
        return args -> {
            Person person = new Person();
            person.setName("Madhan");

            repository.save(person);
            Person saved = repository.findById(person.getId()).orElseThrow(NoSuchElementException::new);
            System.out.println("Saved Person: " + saved.getName());
        };
    }
}