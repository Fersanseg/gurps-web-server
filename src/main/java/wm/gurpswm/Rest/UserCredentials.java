package wm.gurpswm.Rest;

public class UserCredentials {
  private String email;
  private String password;
  private String username;

  public UserCredentials() {}
  
  public void setEmail(String email) { this.email = email; }
  public void setPassword(String password) { this.password = password; }
  public void setUsername(String username) { this.username = username; }
  
  public String getEmail() { return this.email; }
  public String getPassword() { return this.password; }
  public String getUsername() { return this.username; }
}
