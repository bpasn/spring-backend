package com.ecommerce.backend.controllers.brand;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/brands")
public class BrandController {

    @GetMapping("/")
    public ResponseEntity<String>get(){
        return ResponseEntity.ok("Brands");
    }
}
