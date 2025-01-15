package com.baar.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class SampleApplication {
    @GetMapping("/")
    public String hello() {
        return "Hello World!";
    }

    @GetMapping("/test")
    public String test() {
        return "Test.....";
    }

    public static void main(String[] args) {
        SpringApplication.run(SampleApplication.class, args);
    }

}
