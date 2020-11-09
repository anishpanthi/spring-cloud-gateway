package net.app.gateway.security;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class JwtAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

  /**
   * Called when a user has been successfully authenticated.
   *
   * @param request        the request which caused the successful authentication
   * @param response       the response
   * @param authentication the <tt>Authentication</tt> object which was created during
   */
  @Override
  public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
      Authentication authentication) throws IOException, ServletException {
    // no need implementation as no redirect required
  }
}
