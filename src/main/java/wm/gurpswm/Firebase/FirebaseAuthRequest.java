package wm.gurpswm.Firebase;

import wm.gurpswm.Rest.UserCredentials;

public class FirebaseAuthRequest {
    private String email;
    private String password;
    private Boolean returnSecureToken;

    public FirebaseAuthRequest() {}

    public FirebaseAuthRequest(UserCredentials credentials) {
        this.email = credentials.getEmail();
        this.password = credentials.getPassword();
        this.returnSecureToken = true;
    }

    public String getEmail() { return this.email; }
    public String getPassword() { return this.password; }
    public Boolean getReturnSecureToken() { return this.returnSecureToken; }
}
