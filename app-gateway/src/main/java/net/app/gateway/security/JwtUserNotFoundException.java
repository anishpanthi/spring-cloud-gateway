package net.app.gateway.security;

import org.springframework.security.core.AuthenticationException;

public class JwtUserNotFoundException extends AuthenticationException {

  public JwtUserNotFoundException(String msg) {
    super(msg);
  }
}
