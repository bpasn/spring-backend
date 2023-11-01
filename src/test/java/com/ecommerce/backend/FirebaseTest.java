package com.ecommerce.backend;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.util.ResourceUtils;

import com.ecommerce.backend.services.FirebaseService;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class FirebaseTest {
   @Autowired
   private FirebaseService firebaseService;
   @Value("${firebase.buckName")
   private String buckName;
   @Test
    void createFile() throws IOException {
       File file = ResourceUtils.getFile("classpath:12005346_1.png");
       Assertions.assertNotNull(file);
       InputStream inputStream = new FileInputStream(file);
        byte[] fileContent = inputStream.readAllBytes();
        MockMultipartFile multipartFile = new MockMultipartFile("file", "12005346_1.png", "image/png", fileContent);

        String actualString = firebaseService.uploadFire(multipartFile);

        Assertions.assertNotNull(actualString);
        Assertions.assertEquals(buckName + "/" + file.getName(), actualString);

   }
}
