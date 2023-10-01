package com.ecommerce.backend;

import com.ecommerce.backend.services.Helper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class JUnitTestSaveFile {
    private static final String BASE_PATH = "src/main/resources";

    @Autowired
    private Helper helper;


    @Test
    void createFileWithMultipartFile() throws IOException, Exception {
        Path pathFIle = Paths.get("/Users/prpasn/Desktop/chair.jpg");
        File file = pathFIle.toFile();
        InputStream inputStream = new FileInputStream(file);
        byte[] fileContent = inputStream.readAllBytes();
        MockMultipartFile multipartFile = new MockMultipartFile("file", "chair.jpg", "image/jpeg", fileContent);

        // Create a temporary directory for testing
        Path basePath = Paths.get(BASE_PATH);
        Path categoriesFolder = basePath.resolve("static/categories");
        Files.createDirectories(categoriesFolder);

        // Mock the behavior of the file service
        Path expectedFilePath = categoriesFolder.resolve("chair.jpg");

        // Call the saveFile method
        String actualFilePath = helper.saveFileImage(multipartFile,expectedFilePath);

        // Verify that the method returned the expected file path
        Assertions.assertEquals(expectedFilePath.toString(), actualFilePath);

        // CLean up: Delete the temporary directory;
        // Files.deleteIfExists(categoriesFolder);
    }

    @Test
    void createFileNotSupportType() throws IOException {
        IOException ex = Assertions.assertThrows(IOException.class, () -> {
            byte[] fileContent = "Hello, World!".getBytes();
            MockMultipartFile multipartFile = new MockMultipartFile("file", "test.txt", "text/plain", fileContent);
            Path output = Paths.get(BASE_PATH).resolve("static/categories/test.txt");
            helper.saveFileImage(multipartFile,output);
        });
    }
    @Test
    public void createFileWithBase64() throws IOException {
        String content = "Hello World!!";
        String fileName = "test.txt";
        String pathFile = "static/products";
        Path productPath = Paths.get(BASE_PATH).resolve(pathFile);

        // Mock the behavior of the file service
        String expectedFilePath = productPath.resolve(fileName).toString();
        String base64Encode = Base64.getEncoder().encodeToString(content.getBytes());
        String actualFilePath = helper.saveFileImageWithBase64(base64Encode, pathFile, fileName);

        Assertions.assertEquals(expectedFilePath, actualFilePath);
        Files.deleteIfExists(Paths.get(actualFilePath));
    }

}
