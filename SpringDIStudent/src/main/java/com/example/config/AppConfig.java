package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.example.model.Student;

@Configuration
public class AppConfig {

    @Bean
    public Student student() {
        Student s = new Student(201, "Anitha", "Python", 2024);

        // Setter Injection
        s.setCourse("Spring Core");
        s.setYear(2025);

        return s;
    }
}