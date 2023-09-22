package com.firstApp.firstApp.controllers.categories;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.firstApp.firstApp.Exception.BaseException;
import com.firstApp.firstApp.services.CategoryService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/category")
public class CategoriesController {

    private final CategoryService service;

    public CategoriesController(CategoryService service) {
        this.service = service;
    }

    @PostMapping(path = "create", consumes = { "multipart/form-data" })
    ResponseEntity<String> create(@Valid @ModelAttribute ReqCreateCategory request)
            throws BaseException, MethodArgumentNotValidException, IOException {
        service.create(request);
        return ResponseEntity.ok("Create Successfully.");
    }

    @PutMapping("/{id}")
    ResponseEntity<String> update(@PathVariable String id) {
        service.update(Integer.parseInt(id));
        return ResponseEntity.ok("Update Successfully.");
    }

    @DeleteMapping("/{id}")
    ResponseEntity<String> delete(@PathVariable String id) {
        service.delete(Integer.parseInt(id));
        return ResponseEntity.ok("Delete Successfully.");
    }
}
