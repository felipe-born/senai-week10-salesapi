package br.com.senai.semana10.salesapi.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/healthz")
public class HealthzController {

    @GetMapping
    public ResponseEntity<String> healthz() {
        return new ResponseEntity<>("Its error", HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/status")
    public String healthStatus() {
        return "Status -> All services running";
    }

    @PostMapping("/status")
    public String postStatus() {
        return "I'm saving a new status";
    }
}
