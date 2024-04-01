package net.app.authentication.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
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

  private String username;

  private String password;

  private String role;

  private Boolean isActive;

  private LocalDateTime createdOn;

  private LocalDateTime updatedOn;
}
