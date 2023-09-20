package com.firstApp.firstApp.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/demo")
@RestController
public class DemoController {
    @GetMapping
    public ResponseEntity<String> getDemo(){
        return ResponseEntity.ok("Welcome to my application");
    }

}
