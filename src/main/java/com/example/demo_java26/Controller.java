package com.example.demo_java26;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ThreadLocalRandom;

@Slf4j
@RestController
public class Controller {

    @GetMapping
    public ResponseEntity<?> ok() {
        log.info("This API is okay!!");
        return ResponseEntity.ok("ok ok");
    }

    @GetMapping("random")
    public ResponseEntity<?> random(@RequestParam(required = false, defaultValue = "0") int number) {
        if (number == 0) {
            number = ThreadLocalRandom.current().nextInt(1, 6);
            if (number > 3) {
                log.error("Random number is not expected: {}", number);
            }
            else {
                log.warn("Random number is temp: {}", number);
            }
        }
        log.info("Random number is {}", number);
        return ResponseEntity.ok(number);
    }

    @GetMapping("divide")
    public ResponseEntity<?> divide(@RequestParam(required = false) Double a, @RequestParam(required = false, defaultValue = "0") Double b) {
        Double result = a / b;
        log.info("Divide result is {}/{} = {}", a, b, result);
        return ResponseEntity.ok(result);
    }
}
