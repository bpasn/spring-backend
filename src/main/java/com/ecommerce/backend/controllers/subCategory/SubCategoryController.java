package com.ecommerce.backend.controllers.subCategory;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/sub-category")
public class SubCategoryController {
    @GetMapping("/")
    public ResponseEntity<String>get(){
        return ResponseEntity.ok("subCategory");
    }
}
