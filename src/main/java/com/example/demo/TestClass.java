package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestClass {
    @GetMapping("/webhook")
    public ResponseEntity<String> verifyWebhook(@RequestParam("hub.mode") String mode,
                                                @RequestParam("hub.verify_token") String verifyToken,
                                                @RequestParam("hub.challenge") String challenge) {
        if ("subscribe".equals(mode) && "eastest".equals(verifyToken)) {
            // If the mode is 'subscribe' and verify token matches, return the challenge
            return ResponseEntity.ok(challenge);
        } else {
            // If verification fails, return an error response
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Verification failed");
        }
    }
}
