package com.firstApp.firstApp.controllers.categories;

import jakarta.annotation.Nonnull;
import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Data
public class ReqCreateCategory {
    @NotNull(message = "Categories is required")
    @Size(min = 2, max = 20)
    private String cName;

    @NotNull(message = "Picture of Categories is required")
    private MultipartFile cImage;

    private String cDescription = null;
}
