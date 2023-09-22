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
        Path source = Paths.get(BASE_PATH);
        Path newFolder = Paths.get(source.toAbsolutePath() + "/static/categories");
        if (!Files.exists(newFolder)) {
            Files.createDirectories(newFolder);
        }
        String fileName = cImage.getOriginalFilename();
        byte[] getByte = cImage.getBytes();
        File file = new File(newFolder.toString(), fileName);
        try (OutputStream os = new FileOutputStream(file)) {
            os.write(getByte);
        }
        return String.format("%s/static/categories/%s", BASE_PATH, fileName);
    }

}
