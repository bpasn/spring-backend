package com.ecommerce.backend.interfaces;

import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.WriterException;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;

public interface IHelper {
    String saveFileImage(MultipartFile file, Path outputPath) throws IOException;

    String saveFileImageWithBase64(String base64, String path, String filename) throws IOException;

    void deleteFile(String pathFile) throws IOException;

    String generateQRCode(String date, String filePath) throws IOException, ChecksumException, NotFoundException, FormatException, WriterException;

    String readQRCode(String filePath) throws IOException, Exception;
}
