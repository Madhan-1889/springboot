package com.example.demo;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {
    
    private static final String template = "I am %s!, and I'm %d years old.";
    private final AtomicLong atomicLong = new AtomicLong();

    @GetMapping("/person")
    public Person getPersonDetails(
            @RequestParam(value = "name", defaultValue = "Madhan") String name,
            @RequestParam(value = "age", defaultValue = "23") int age,
            @RequestParam(value = "gender", defaultValue = "Male") String gender) {
        
        String message = String.format(template, name, age, gender);
        return new Person(atomicLong.incrementAndGet(), name, age, gender, message);
    }
}
