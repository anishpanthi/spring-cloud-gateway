package net.app.gateway.security;

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
      var body = Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary(secret))
          .parseClaimsJws(token).getBody();
      var userId = body.get("userId").toString();
      var subject = body.getSubject();
      var role = (String) body.get("role");
      jwtUserDto = new JwtUserDto(Long.parseLong(userId), subject, role);
      log.info("Logged in User:: {}", jwtUserDto.toString());
    } catch (JwtException e) {
      log.error("", e);
    }

    return jwtUserDto;
  }
}
