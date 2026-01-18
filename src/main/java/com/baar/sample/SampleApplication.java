package com.baar.sample;

import com.baar.sample.model.Person;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URL;
import java.util.List;

@Slf4j
@RestController
@SpringBootApplication
public class SampleApplication {
    @GetMapping("/")
    public List<Person> hello() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        URL url = SampleApplication.class.getResource("/data/persons.json");
        List<Person> persons = objectMapper.readValue(url, new TypeReference<List<Person>>() {
        });
        log.info("Return lis of persons!");
        return persons;
    }

    @GetMapping("/test")
    public String test() {
        return "Test.....!";
    }

    public static void main(String[] args) {
        SpringApplication.run(SampleApplication.class, args);
    }

}
