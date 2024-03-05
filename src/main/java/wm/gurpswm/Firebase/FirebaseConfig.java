package wm.gurpswm.Firebase;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

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
    Resource configFile = new ClassPathResource("firebase-config.json");
    if (configFile.exists()) {
      InputStream serviceAccount = configFile.getInputStream();
      
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
