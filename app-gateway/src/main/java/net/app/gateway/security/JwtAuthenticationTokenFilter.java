package net.app.gateway.security;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.OrRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

@Slf4j
public class JwtAuthenticationTokenFilter extends AbstractAuthenticationProcessingFilter {

  @Value("${jwt.header}")
  private String tokenHeader;

  private static final List<RequestMatcher> PATHS = Collections.singletonList(
      new AntPathRequestMatcher("/v1/**")
  );

  public JwtAuthenticationTokenFilter() {
    super(new OrRequestMatcher(PATHS));
  }

  /**
   * Performs actual authentication.
   * <p>
   * The implementation should do one of the following:
   * <ol>
   * <li>Return a populated authentication token for the authenticated user, indicating
   * successful authentication</li>
   * <li>Return null, indicating that the authentication process is still in progress.
   * Before returning, the implementation should perform any additional work required to
   * complete the process.</li>
   * <li>Throw an <tt>AuthenticationException</tt> if the authentication process fails</li>
   * </ol>
   *
   * @param request  from which to extract parameters and perform the authentication
   * @param response the response, which may be needed if the implementation has to do a redirect as
   *                 part of a multi-stage authentication process (such as OpenID).
   * @return the authenticated user token, or null if authentication is incomplete.
   * @throws AuthenticationException if authentication fails.
   */
  @Override
  public Authentication attemptAuthentication(HttpServletRequest request,
      HttpServletResponse response) throws AuthenticationException, IOException, ServletException {
    String header = request.getHeader(this.tokenHeader);

    String authToken;

    if (header != null && header.startsWith("Bearer ")) {
      authToken = header.substring(7);
    } else {
      throw new JwtTokenMissingException("No JWT token found in request headers");
    }

    JwtAuthenticationToken authRequest = new JwtAuthenticationToken(authToken);

    return getAuthenticationManager().authenticate(authRequest);
  }

  @Override
  protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult)
      throws IOException, ServletException {
    super.successfulAuthentication(request, response, chain, authResult);

    log.info("Authenticated User: {}", authResult.getPrincipal());
    // As this authentication is in HTTP header, after success we need to continue the request normally
    // and return the response as if the resource was not secured at all
    chain.doFilter(request, response);
  }
}
