package com.firstApp.firstApp.services;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class Helper {

    @Value("${mount_path}")
    private String BASE_PATH;
    public String saveFile(MultipartFile cImage) throws IOException {        
        // Define the base path and the subfolder for categories
        Path basePath = Paths.get(BASE_PATH);
        Path categoriesFolder = basePath.resolve("static/categories");

        // create The Categories Folders if it doesn't exist
        if (!Files.exists(categoriesFolder)) {
            Files.createDirectories(categoriesFolder);
        }

        // Get the original file name and its byte data
        String fileName = cImage.getOriginalFilename();
        byte[] getByte = cImage.getBytes();


        // Create the target file
        Path targetFilePath = categoriesFolder.resolve(fileName);

        // Write the file using try-with-resources
        try (OutputStream os = new FileOutputStream(String.valueOf(targetFilePath))) {
            os.write(getByte);
        }

        // Return the file path as string
        return targetFilePath.toString();
//        return String.format("%s/static/categories/%s", BASE_PATH, fileName);
    }

}
