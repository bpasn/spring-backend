package com.ecommerce.backend.services;

import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.BucketInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.cloud.FirestoreClient;
import com.google.firebase.cloud.StorageClient;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

@Service
public class FirebaseService {

    public String uploadFire(String fileName,MultipartFile image) throws IOException {
        // Initialize a Storage client
        Storage storage = StorageOptions.newBuilder()
                .setProjectId("your-project-id") // Replace with your Google Cloud project ID
                .build()
                .getService();

        // Create a bucket reference
        Bucket bucket = storage.create(BucketInfo.newBuilder("bucketName")
//                .setStorageClass(BucketInfo.StorageClass.COLDLINE)
                .build());


        // Upload the image
        bucket.create(fileName, image.getBytes(), image.getContentType());

        return "gs://" + "bucketName" + "/" + fileName;
    }
}
