package net.app.gateway.security;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JwtUserDto implements Serializable {

  private Long id;

  private String username;

  private String role;
}
