package com.ecommerce.backend.controllers.categories;

import java.io.IOException;
import java.util.List;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import com.ecommerce.backend.Exception.BaseException;
import com.ecommerce.backend.controllers.DataTableRequest;
import com.ecommerce.backend.dto.CategoriesDTO;
import com.ecommerce.backend.dto.DataTableDTO;
import com.ecommerce.backend.services.CategoryService;

import jakarta.validation.Valid;

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
    @PatchMapping("update")
    ResponseEntity<String> update(@RequestBody UpdateCategoryRequest req)
            throws BaseException, MethodArgumentNotValidException, IOException {
        return ResponseEntity.status(201).body(service.update(req));
    }
    @DeleteMapping("/delete/{id}")
    ResponseEntity<String> delete(@RequestPart(name = "id") Integer id)
            throws BaseException {
        service.deleteById(id);
        return ResponseEntity.status(201).body("Delete category successfully!");
    }

    @GetMapping("get-all")
    public ResponseEntity<List<CategoriesDTO>> getAll() {
        return ResponseEntity.ok(service.getAllToDto());
    }

    @GetMapping("dataTable")
    public ResponseEntity<DataTableDTO<CategoriesDTO>> getDatatable(@ModelAttribute DataTableRequest request) {
        return ResponseEntity.ok(service.getDataTable(
                request.getPage(),
                request.getPageSize()));
    }
}
