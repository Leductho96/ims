package com.example.interviewmanagementsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class InterviewManagementSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(InterviewManagementSystemApplication.class, args);
    }

}
