package net.app.authentication.security.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.xml.bind.DatatypeConverter;
import java.security.Key;
import java.time.LocalDateTime;
import java.util.Date;
import javax.crypto.spec.SecretKeySpec;
import net.app.authentication.security.dto.JwtUserDto;
import net.app.authentication.util.DateUtil;

/**
 * @author Anish Panthi
 */
public class JwtTokenGenerator {

  public static String generateToken(JwtUserDto jwtUserDto, String secret){
    final LocalDateTime expirationDateTime = LocalDateTime.now().plusHours(5);

    SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

    byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(secret);
    Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

    Claims claims = Jwts.claims().setSubject(jwtUserDto.getUsername());
    claims.put("firstName", jwtUserDto.getFirstName());
    claims.put("lastName", jwtUserDto.getLastName());
    claims.put("email", jwtUserDto.getEmail());
    claims.put("role", jwtUserDto.getRole());

    return Jwts.builder()
        .setClaims(claims)
        .setIssuedAt(new Date())
        .setExpiration(DateUtil.localDateTimeToDate(expirationDateTime))
        .signWith(signatureAlgorithm, signingKey)
        .compact();
  }
}
