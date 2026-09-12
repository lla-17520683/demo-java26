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
            number = ThreadLocalRandom.current().nextInt(0, 6);
            if (number > 3) {
                log.error("Random number is prohibited: {}", number);
            }
            else {
                log.warn("Random number is not expected: {}", number);
            }
        }
        log.info("Random number is {}", number);
        return ResponseEntity.ok(number);
    }

    @GetMapping("divide")
    public ResponseEntity<?> divide(@RequestParam(required = false) Double a, @RequestParam(required = false) Double b) {
        Double result;
        try {
            result = a / b;
            log.info("Divide result: {}/{} = {}", a, b, result);
        }
        catch (Exception e) {
            log.error("Error during division: {}", e.getMessage());
            throw new RuntimeException("Error during division", e);
//            return ResponseEntity.badRequest().body("Error during division: " + e.getMessage());
        }
        return ResponseEntity.ok(result);
    }
}
