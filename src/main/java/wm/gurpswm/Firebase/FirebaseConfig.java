package wm.gurpswm.Firebase;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.context.annotation.Configuration;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

import jakarta.annotation.PostConstruct;


@Configuration
public class FirebaseConfig {
    private static final String FB_KEY = "AIzaSyBPymmztNuVSLdjXo1BWyr7dDleE7X9qE4";
    private static final String IDTOOLKIT_URL = "https://identitytoolkit.googleapis.com/v1/accounts:signInWithPassword?key=";

    @PostConstruct
    public void fbInit() throws IOException {
        FirebaseOptions options = null;
        if (new File("./src/main/resources/firebase-config.json").exists()) {
            InputStream serviceAccount = getClass().getClassLoader().getResourceAsStream("firebase-config.json");
            
            options = FirebaseOptions.builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .build();
        } else {
            options = FirebaseOptions.builder()
                .setCredentials(GoogleCredentials.getApplicationDefault())
                .build();
        }

        FirebaseApp.initializeApp(options);
    }

    public static String getTokenUrl() {
        return IDTOOLKIT_URL + FB_KEY;
    }
}
