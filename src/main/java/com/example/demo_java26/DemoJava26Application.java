package com.example.demo_java26;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class DemoJava26Application {

    static void main(String[] args) {
        SpringApplication.run(DemoJava26Application.class, args);
        log.debug("Hello everyone! Let go!!! ...ヾ(≧▽≦*)o");
    }

}
