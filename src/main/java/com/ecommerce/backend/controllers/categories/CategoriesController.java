package com.ecommerce.backend.controllers.categories;

import java.io.IOException;
import java.util.List;

import com.ecommerce.backend.interfaces.ICategory;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.backend.Exception.BaseException;
import com.ecommerce.backend.services.CategoryService;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api/v1/category")
@OpenAPIDefinition
@SecurityRequirement(name = "bearerAuth")
public class CategoriesController {

    private final ICategory service;

    public CategoriesController(CategoryService service) {
        this.service = service;
    }

    @PostMapping(path = "create", consumes = { "multipart/form-data" })
    ResponseEntity<String> create(@Valid @ModelAttribute ReqCreateCategory request)
            throws BaseException, MethodArgumentNotValidException, IOException {
        service.create(request);
        return ResponseEntity.status(201).body("Create Successfully.");
    }

    @GetMapping(value = "/get")
    public ResponseEntity<List<CategoriesResponse>> get() {
        return ResponseEntity.ok(service.get());
    }

    @GetMapping(value = "/get/{id}")
    public ResponseEntity<CategoriesResponse> get(@PathVariable String id) {
        return ResponseEntity.ok(service.getById(Integer.parseInt(id)));
    }

    @PutMapping("/update")
    ResponseEntity<String> update(@Valid @ModelAttribute ReqUpdateCategory request) throws IOException {
        service.update(request);
        return ResponseEntity.ok("Update Successfully.");
    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity<String> delete(@PathVariable String id) {
        service.delete(Integer.parseInt(id));
        return ResponseEntity.ok("Delete Successfully.");
    }
}
