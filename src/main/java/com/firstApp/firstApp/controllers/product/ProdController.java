package com.firstApp.firstApp.controllers.product;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.firstApp.firstApp.services.ProdService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/product")
public class ProdController {
    private final ProdService service;

    public ProdController(ProdService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public ResponseEntity<String> create(@Valid @RequestBody ReqCreate product) throws IOException {
        return ResponseEntity.status(201).body(service.create(product));
    }

}
