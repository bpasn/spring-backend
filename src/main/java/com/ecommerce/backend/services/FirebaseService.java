package com.ecommerce.backend.services;

import com.google.auth.Credentials;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.storage.*;

import lombok.extern.log4j.Log4j2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@Service
@Log4j2
public class FirebaseService {

    @Value("${firebase.project_id}")
    private String projectId;
    @Value("${firebase.buckName}")
    private String buckName;
    public String uploadFire(MultipartFile file) throws IOException {
            log.info("Original Filename: {}", file.getOriginalFilename());
            File fileKey = ResourceUtils.getFile("classpath:private-firebase-key.json");
            Credentials credentials = GoogleCredentials.fromStream(new FileInputStream(fileKey));

            // Initialize a Storage client
            Storage storage = StorageOptions.newBuilder()
                    .setProjectId(projectId)
                    .setCredentials(credentials)
                    .build()
                    .getService();

            String fileName = file.getOriginalFilename();
            BlobId blobId = BlobId.of("gs://famous-archway-274409.appspot.com/images/products", "p1.jpeg");
           Blob blob = storage.get(blobId);
           log.info(blob.getStorage());
            return buckName +"/"+ fileName;

    }
}
