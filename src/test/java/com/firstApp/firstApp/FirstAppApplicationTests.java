package com.firstApp.firstApp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.web.ServerProperties.Tomcat.Resource;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.util.ResourceUtils;

import com.firstApp.firstApp.controllers.categories.CategoriesController;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;

import javax.imageio.stream.FileImageInputStream;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.hamcrest.Matchers.containsString;

@SpringBootTest
@WebMvcTest(CategoriesController.class)
class FirstAppApplicationTests {

    @Autowired
    private MockMvc mvc;
    private final String token = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJleGFtcGxlQGJhY2tlbmQuY29tIiwiaWF0IjoxNjk1Mzc3NzEyLCJleHAiOjE2OTUzNzkxNTJ9.VtRs7YV0UZDQxt-vHuPw8NF9N8j523x8pa9pChs1kVo";

    @Value("${mount_path}")
    private String BASE_PATH;

    @Test
    void createCategories() throws Exception, IOException {
        
    }
}
