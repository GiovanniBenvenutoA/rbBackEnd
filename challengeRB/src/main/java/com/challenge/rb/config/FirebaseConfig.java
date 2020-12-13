package com.challenge.rb.config;

import java.io.FileInputStream;
import java.io.IOException;


import org.springframework.context.annotation.Configuration;


import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;


@Configuration
public class FirebaseConfig {
	
	FirebaseApp createFireBaseApp() throws IOException {
		
		
            FileInputStream serviceAccount =
                    new FileInputStream("/Users/giovannibenvenuto/Documents/workspace-spring-tool-suite-4-4.8.1.RELEASE/challengeRB/desafiobr-aef1d-firebase-adminsdk-akkio-794f38599d.json");

            FirebaseOptions options = new FirebaseOptions.Builder()
            		  .setCredentials(GoogleCredentials.fromStream(serviceAccount))
            		  .setDatabaseUrl("https://desafiobr-aef1d-default-rtdb.firebaseio.com")
            		  .build();

            		return FirebaseApp.initializeApp(options);
       
        
	}
    

}

