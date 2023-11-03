package com.ecommerce.backend.controllers.categories;

import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class UpdateCategoryRequest {
    private String id;
    private String cName;
}
