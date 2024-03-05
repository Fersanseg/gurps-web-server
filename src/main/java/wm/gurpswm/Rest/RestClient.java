package wm.gurpswm.Rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class RestClient {
  public static <T, U> ResponseEntity<U> post(T body, String url, Class<U> responseType, Object... uriVars) {
    return new RestTemplate().postForEntity(url, body, responseType, uriVars);
  }
}
