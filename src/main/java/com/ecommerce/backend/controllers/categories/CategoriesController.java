package com.ecommerce.backend.controllers.categories;

import java.io.IOException;
import java.util.List;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.backend.Exception.BaseException;
import com.ecommerce.backend.dto.CategoriesDTO;
import com.ecommerce.backend.services.CategoryService;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping(path = "${apiPrefix}/category")
@OpenAPIDefinition
@SecurityRequirement(name = "bearerAuth")
public class CategoriesController {

    private final CategoryService service;
//
    public CategoriesController(CategoryService service) {
        this.service = service;
    }

    @PostMapping(path = "create", consumes = { "multipart/form-data" })
    ResponseEntity<String> create(@Valid @ModelAttribute CreateCategoryRequest request)
            throws BaseException, MethodArgumentNotValidException, IOException {

        return ResponseEntity.status(201).body(service.create(request));
    }

    @GetMapping(value = "/get-all")
    public ResponseEntity<List<CategoriesDTO>> getAll() {
        return ResponseEntity.ok(service.getAllToDto());
    }
//
//    @GetMapping(value = "/get/{id}")
//    public ResponseEntity<CategoriesResponse> get(@PathVariable String id) {
//        return ResponseEntity.ok(service.getById(Integer.parseInt(id)));
//    }
//
//    @PutMapping("/update")
//    ResponseEntity<String> update(@Valid @ModelAttribute ReqUpdateCategory request) throws IOException {
//        service.update(request);
//        return ResponseEntity.ok("Update Successfully.");
//    }
//
//    @DeleteMapping("/delete/{id}")
//    ResponseEntity<String> delete(@PathVariable String id) {
//        service.delete(Integer.parseInt(id));
//        return ResponseEntity.ok("Delete Successfully.");
//    }
}
