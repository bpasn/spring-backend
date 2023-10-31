package com.ecommerce.backend.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@Configuration
public class FirebaseConfig {
    private final String PRIVATE_KEY_FIREBASE="classpath:private-firebase-key.json";
    @Bean
    public FirebaseApp firebaseApp() throws IOException {
        File privateKey = ResourceUtils.getFile(PRIVATE_KEY_FIREBASE);
        FileInputStream serviceAccount = new FileInputStream(privateKey);

        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .build();

        return FirebaseApp.initializeApp(options);
    }
}
