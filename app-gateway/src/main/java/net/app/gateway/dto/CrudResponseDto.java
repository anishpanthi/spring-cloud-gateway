package net.app.gateway.dto;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Anish Panthi
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CrudResponseDto implements Serializable {

  private String timeStamp;

  private String status;

  private String message;

}
