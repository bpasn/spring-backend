package com.ecommerce.backend;

import com.ecommerce.backend.services.Helper;
import jakarta.validation.Validator;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@ExtendWith(MockitoExtension.class)
@SpringBootTest
class BackendApplicationTests {

    private static final String BASE_PATH = "src/main/resources";

    @Autowired
    private Helper helper;

    @Autowired
    private Validator validator;
//
//    @Test
//    void validate() throws MethodArgumentNotValidException {
//        ReqCreateCategory request = new ReqCreateCategory();
//        byte[] fileContent = "Hello, World!".getBytes();
//        MockMultipartFile multipartFile = new MockMultipartFile("file", "test.txt", "text/plain", fileContent);
//
//        request.setCName("");
//        request.setCImage(multipartFile);
//
//        // Validate the model
//        Set<ConstraintViolation<ReqCreateCategory>> violations = validator.validate(request);
//
//        // Check if there are validation errors for the field name
//        Assertions.assertFalse(violations.isEmpty());
//
//        // You cal also assert specific error messages if needed
//
//    }
//

}
