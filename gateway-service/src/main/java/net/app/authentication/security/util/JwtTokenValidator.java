//package net.app.authentication.security.util;
//
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.JwtException;
//import io.jsonwebtoken.Jwts;
//import jakarta.xml.bind.DatatypeConverter;
//import lombok.extern.slf4j.Slf4j;
//import net.app.authentication.security.dto.JwtUserDto;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;
//
///**
// * @author Anish Panthi
// */
//@Component
//@Slf4j
//public class JwtTokenValidator {
//
//  @Value("${jwt.secret}")
//  private String secret;
//
//  public JwtUserDto parseToken(String token) {
//    JwtUserDto jwtUserDto = null;
//
//    try {
//      Claims body = Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary(secret))
//          .parseClaimsJws(token).getBody();
//      jwtUserDto = new JwtUserDto((String) body.get("firstName"), (String) body.get("lastName"),
//          (String) body.get("email"), (String) body.get("sub"), (String) body.get("role"));
//    } catch (JwtException e) {
//      log.error("Exception while parsing token: {}", e.getMessage());
//    }
//    return jwtUserDto;
//  }
//}
