package com.ecommerce.backend;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

@SpringBootTest
public class FirebaseTest {
   @Test
    void createFile() throws IOException {
       File file = ResourceUtils.getFile("classpath:static/categories/electronic.jpg");
       Assertions.assertNotNull(file);
   }
}
