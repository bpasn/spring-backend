package com.firstApp.firstApp.controllers.categories;

import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ReqCreateCategory {
    @NotNull(message = "Categories is required")
    @Size(min = 2)
    private String cName;

    @NotNull(message = "Picture of Categories is required")
    private MultipartFile cImage;

    private String cDescription = null;
}
