package net.app.gateway.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import jakarta.xml.bind.DatatypeConverter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class JwtTokenValidator {

  @Value("${jwt.secret}")
  private String secret;

  public JwtUserDto parseToken(String token) {

    JwtUserDto jwtUserDto = null;

    try {
      Claims body = Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary(secret)).parseClaimsJws(token).getBody();
      String userId = body.get("userId").toString();
      String subject = body.getSubject();
      String role = (String) body.get("role");
      jwtUserDto = new JwtUserDto(Long.parseLong(userId), subject, role);
      log.info("Logged in User:: {}", jwtUserDto.toString());
    } catch (JwtException e) {
      log.error("", e);
    }

    return jwtUserDto;
  }
}
