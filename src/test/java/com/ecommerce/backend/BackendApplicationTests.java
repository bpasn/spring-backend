package com.ecommerce.backend;

import com.ecommerce.backend.controllers.categories.ReqCreateCategory;
import com.ecommerce.backend.services.Helper;
import com.google.zxing.WriterException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.Set;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
@Log4j2
class BackendApplicationTests {

    private static final String BASE_PATH = "src/main/resources";

    @Autowired
    private Helper helper;

    @Autowired
    private Validator validator;

    @Test
    void validate() throws MethodArgumentNotValidException {
        ReqCreateCategory request = new ReqCreateCategory();
        byte[] fileContent = "Hello, World!".getBytes();
        MockMultipartFile multipartFile = new MockMultipartFile("file", "test.txt", "text/plain", fileContent);

        request.setCName("");
        request.setCImage(multipartFile);

        // Validate the model
        Set<ConstraintViolation<ReqCreateCategory>> violations = validator.validate(request);

        // Check if there are validation errors for the field name
        Assertions.assertFalse(violations.isEmpty());

        // You cal also assert specific error messages if needed

    }


}
