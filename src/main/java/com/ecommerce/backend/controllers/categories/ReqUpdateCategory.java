package com.ecommerce.backend.controllers.categories;

import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ReqUpdateCategory {
    private String cName;

    private Optional<MultipartFile> cImage;

    private String cDescription;
}
