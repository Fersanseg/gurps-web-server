package wm.gurpswm.Firebase;

import org.springframework.security.authentication.AbstractAuthenticationToken;

public class FirebaseAuthenticationToken extends AbstractAuthenticationToken {
  private final String userId;
  private final String token;

  public FirebaseAuthenticationToken(String userId, String token) {
    super(null);
    this.userId = userId;
    this.token = token;
    setAuthenticated(true);
  }

  @Override
  public Object getPrincipal() {
    return userId;
  }

  @Override
  public Object getCredentials() {
    return token;
  }
}
