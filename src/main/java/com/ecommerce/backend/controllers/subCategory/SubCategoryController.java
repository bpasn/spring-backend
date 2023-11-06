package com.ecommerce.backend.controllers.subCategory;

import com.ecommerce.backend.controllers.DataTableRequest;
import com.ecommerce.backend.dto.DataTableDTO;
import com.ecommerce.backend.dto.SubCategoryDTO;
import com.ecommerce.backend.services.SubCategoryService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("${apiPrefix}/sub-category")
@RestController
@SecurityRequirement(name = "bearerAuth")

public class SubCategoryController {
    private final SubCategoryService subCategoryService;

    public SubCategoryController(SubCategoryService subCategoryService) {
        this.subCategoryService = subCategoryService;
    }

    @GetMapping("/")
    public ResponseEntity<String>get(){
        return ResponseEntity.ok("subCategory");
    }
    @GetMapping("/dataTable")
    public ResponseEntity<DataTableDTO<SubCategoryDTO>> getDataTable(@ModelAttribute DataTableRequest request){
        return ResponseEntity.ok(subCategoryService.getDataTable(
                request.getPage(),
                request.getPageSize()
        ));
    }
}
