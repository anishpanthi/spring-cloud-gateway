package net.app.authentication.security.dto;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JwtUserDto implements Serializable {

  private String firstName;

  private String lastName;

  private String email;

  private String username;

  private String role;
}
