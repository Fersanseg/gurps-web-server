package wm.gurpswm;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import wm.gurpswm.Firebase.FirebaseAuthRequest;
import wm.gurpswm.Firebase.FirebaseAuthResponse;
import wm.gurpswm.Firebase.FirebaseConfig;
import wm.gurpswm.Rest.ClientResponse;
import wm.gurpswm.Rest.RestClient;
import wm.gurpswm.Rest.UserCredentials;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping(path = "/app", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class AuthController {
    
    @PostMapping(path = "/login")
    public ResponseEntity<ClientResponse> login(@RequestBody UserCredentials body) throws Exception {
        return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        // return new ResponseEntity<>(firebaseLogin(body), HttpStatus.OK);
    }

    private ClientResponse firebaseLogin(UserCredentials credentials) throws Exception {
        return new ClientResponse(true, "TEST ERROR MESSAGE HELLO");
        // FirebaseAuthRequest req = new FirebaseAuthRequest(credentials);
        // String url = FirebaseConfig.getTokenUrl();

        // try {
        //     return new ClientResponse(true, "asdfasdf");
        //     // return new ClientResponse(RestClient.post(req, url, FirebaseAuthResponse.class, "bar"));
        // }
        // catch (HttpClientErrorException e) {
        //     String excMessage = e.getMessage();
        //     if (excMessage.contains("INVALID_EMAIL")) 
        //         return new ClientResponse(true, "Invalid email format");
            
        //     if (excMessage.contains("INVALID_LOGIN_CREDENTIALS")) {
        //         return new ClientResponse(true, "Invalid login credentials");
        //     }
        
        //     throw e;
        // }
    }
}
