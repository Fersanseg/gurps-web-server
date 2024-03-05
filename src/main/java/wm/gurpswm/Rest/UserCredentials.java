package wm.gurpswm.Rest;

public class UserCredentials {
  private String email;
  private String password;

  public UserCredentials() {}
  
  public void setEmail(String email) { this.email = email; }
  public void setPassword(String password) { this.password = password; }
  
  public String getEmail() { return this.email; }
  public String getPassword() { return this.password; }
}
