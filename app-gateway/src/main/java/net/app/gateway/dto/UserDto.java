package net.app.gateway.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto implements Serializable {

  private Long id;

  private String firstName;

  private String lastName;

  private String email;

  private String contact;

  private String username;

  @JsonIgnore
  private String password;
}
