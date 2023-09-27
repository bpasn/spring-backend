package com.ecommerce.backend;

import com.ecommerce.backend.services.Helper;
import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.WriterException;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.nio.file.Paths;

@SpringBootTest
@Log4j2
public class JUnitTestQRCode {
    @Value("${mount_path}")
    private String BASE_PATH;

    @Autowired
    private Helper helper;
    @Test
    void generateQRCode() throws IOException, WriterException {
        String data = "012345678905";
        String path = "static/qrcode/qrcode.png";
        String expected = Paths.get(BASE_PATH).resolve(path).toString();
        String actual = helper.generateQRCode(data, path);

        Assertions.assertEquals(expected,actual);
        log.info("READ 🥰");
    }

    @Test
    void readQRCode() throws ChecksumException, NotFoundException, IOException, FormatException {

        String expected = "012345678905";
        String path = "static/qrcode/qrcode.png";
        String actual = helper.readQRCode(path);

        Assertions.assertEquals(expected,actual);
    }
}
