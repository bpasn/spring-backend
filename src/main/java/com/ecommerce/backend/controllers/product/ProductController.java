package com.ecommerce.backend.controllers.product;

import java.io.IOException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.backend.dto.ProductDTO;
import com.ecommerce.backend.services.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {
    private final ProductService service;
    public ProductController(ProductService service) {
        this.service = service;
    }
    @PostMapping("/create")
    public ResponseEntity<String> create(@Valid @RequestBody CreateProductRequest product) throws IOException {
        return ResponseEntity.status(201).body(service.create(product));
    }
    @GetMapping("/get")
    public ResponseEntity<List<ProductDTO>> getAll(){
        return ResponseEntity.ok(service.getAllToDto());
    }
    @GetMapping("/get/{productId}")
    public ResponseEntity<ProductDTO> getById(@RequestParam(name = "productId") Integer productId){
        return ResponseEntity.ok(service.getByIdToDto(productId));
    }

}
