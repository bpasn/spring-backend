package com.firstApp.firstApp;

import com.firstApp.firstApp.controllers.categories.ReqCreateCategory;
import com.firstApp.firstApp.services.Helper;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.Set;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class FirstAppApplicationTests {

    private static final String BASE_PATH = "src/main/resources";

    @Mock
    @Autowired
    private Helper helper;

    @Autowired
    private Validator validator;

    @Test
    void createCategories() throws IOException, Exception {
        byte[] fileContent = "Hello, World!".getBytes();
        MockMultipartFile multipartFile = new MockMultipartFile("file", "test.txt", "text/plain", fileContent);

        // Create a temporary directory for testing
        Path basePath = Paths.get(BASE_PATH);
        Path categoriesFolder = basePath.resolve("static/categories");
        Files.createDirectories(categoriesFolder);

        // Mock the behavior of the file service
        String expectedFilePath = categoriesFolder.resolve("test.txt").toString();
        when(helper.saveFile(multipartFile)).thenReturn(expectedFilePath);

        // Call the saveFile method
        String actualFilePath = helper.saveFile(multipartFile);

        // Verify that the method returned the expected file path
        Assertions.assertEquals(expectedFilePath, actualFilePath);

        // CLean up: Delete the temporary directory;
        // Files.deleteIfExists(categoriesFolder);
    }

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

    @Test
    public void createFileWithBase64() throws IOException, Exception {
        final String content = "Hello World!!";
        final String fileName = "test.txt";
        final String pathFile = "/static/products/";
        Path basePath = Paths.get(BASE_PATH);
        Path productPath = basePath.resolve(pathFile);

        // Mock the behavior of the file service
        String expectedFilePath = productPath.resolve(fileName).toString();
        String base64Encode = Base64.getEncoder().encodeToString(content.getBytes());
        String actualFilePath = helper.saveFileWithBase64(base64Encode, expectedFilePath, fileName);
        Assertions.assertEquals(expectedFilePath, actualFilePath);
    }
}
