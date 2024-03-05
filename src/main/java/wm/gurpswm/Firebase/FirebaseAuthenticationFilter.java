package wm.gurpswm.Firebase;

import java.io.IOException;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class FirebaseAuthenticationFilter extends OncePerRequestFilter {

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
      throws ServletException, IOException {

    String token = getToken(request);

    if (token != null) {
      try {
        FirebaseAuth fbAuth = FirebaseAuth.getInstance();
        FirebaseToken fbToken = fbAuth.verifyIdToken(token);

        FirebaseAuthenticationToken authentication =
          new FirebaseAuthenticationToken(fbToken.getUid(), token);

        SecurityContextHolder.getContext().setAuthentication(authentication);
      } catch (FirebaseAuthException e) {
          response.setStatus(HttpServletResponse.SC_EXPECTATION_FAILED);
          return;
      }
    }

    filterChain.doFilter(request, response);
  }

  private String getToken(HttpServletRequest request) {
    String header = request.getHeader(HttpHeaders.AUTHORIZATION);

    if (StringUtils.hasText(header) && header.startsWith("Bearer ")) {
      return header.substring(7);
    }
    return null;
  }
}
