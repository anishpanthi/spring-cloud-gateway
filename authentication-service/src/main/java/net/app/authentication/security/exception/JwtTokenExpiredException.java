package net.app.authentication.security.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * @author Anish Panthi
 */
public class JwtTokenExpiredException extends AuthenticationException {

  /**
   * Constructs an {@code AuthenticationException} with the specified message and no root cause.
   *
   * @param msg the detail message
   */
  public JwtTokenExpiredException(String msg) {
    super(msg);
  }
}
