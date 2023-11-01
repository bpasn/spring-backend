package com.ecommerce.backend.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@Configuration
@Log4j2
public class FirebaseConfig {
    private final String PRIVATE_KEY_FIREBASE="classpath:private-firebase-key.json";
    public FirebaseApp firebaseApp() throws IOException {
        File privateKey = ResourceUtils.getFile(PRIVATE_KEY_FIREBASE);
        FileInputStream serviceAccount = new FileInputStream(privateKey);

        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .build();

        log.info("FirebaseApp is already");
        log.info(options.getDatabaseUrl());
        return FirebaseApp.initializeApp(options);
    }
}
