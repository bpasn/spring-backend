package com.ecommerce.backend.services;

import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Base64;

import com.ecommerce.backend.interfaces.IHelper;
import com.google.zxing.*;
import com.google.zxing.Reader;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageConfig;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.oned.UPCAWriter;
import lombok.extern.log4j.Log4j2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;

@Service
@Log4j2
public class Helper implements IHelper {

    @Value("${mount_path}")
    private String BASE_PATH;

    private final String[] supportType = {"image/png", "image/jpeg"};

    public String saveFile(MultipartFile cImage) throws IOException {
        // Define the base path and the subfolder for categories
        if (!Arrays.asList(supportType).contains(cImage.getContentType())) {
            throw new IOException(String.format("%s File Type  Doesn't Support.", cImage.getContentType()));
        }
        Path basePath = Paths.get(BASE_PATH);
        Path categoriesFolder = basePath.resolve("static/categories");

        // create The Categories Folders if it doesn't exist
        if (!Files.exists(categoriesFolder)) {
            Files.createDirectories(categoriesFolder);
        }

        log.info(cImage.getContentType());
        // Get the original file name and its byte data
        String fileName = cImage.getOriginalFilename();
        byte[] getByte = cImage.getBytes();

        // Create the target file
        Path targetFilePath = categoriesFolder.resolve(fileName);

        // Write the file using try-with-resources
        try (OutputStream os = Files.newOutputStream(targetFilePath)) {
            os.write(getByte);
        }

        // Return the file path as string
        return targetFilePath.toString();
    }

    @Override
    public String generateQRCode(String date, String filePath) throws IOException, WriterException {
        int width = 200, height = 300;
        String format = "png";

        BitMatrix bitMatrix = new MultiFormatWriter().encode(date, BarcodeFormat.QR_CODE, width, height);
        BufferedImage image = MatrixToImageWriter.toBufferedImage(bitMatrix);

        Path output = Paths.get(BASE_PATH).resolve(filePath);
        if(!Files.exists(output)){
            String directory = output.toString().replace(output.getFileName().toString(),"");
            Files.createDirectories(Paths.get(directory));
        }
        ImageIO.write(image,format, output.toFile());

        return output.toString();
    }

    @Override
    public String readQRCode(String filePath) throws IOException, ChecksumException, NotFoundException, FormatException {
        Path rootBath = Paths.get(BASE_PATH).resolve(filePath);
        BufferedImage image = ImageIO.read(new File(rootBath.toString()));
        BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(image)));
        Reader reader = new MultiFormatReader();

        Result result = reader.decode(binaryBitmap);
        return result.getText();
    }

    @Override
    public void deleteFile(String pathFile) throws IOException {
        Path fullpath = Paths.get(pathFile);
        Files.deleteIfExists(fullpath);
    }

    @Override
    public String saveFileWithBase64(String base64, String path, String filename) throws IOException {
        Path setPath = Paths.get(BASE_PATH).resolve(path);
        if (!Files.exists(setPath)) {
            Files.createDirectories(setPath);
        }

        byte[] getBytes = Base64.getDecoder().decode(base64);

        try (OutputStream os = Files.newOutputStream(setPath.resolve(filename))) {
            os.write(getBytes);
        }

        return setPath.resolve(filename).toString();
    }
}
