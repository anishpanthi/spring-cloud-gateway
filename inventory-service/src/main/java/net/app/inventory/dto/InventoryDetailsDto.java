package net.app.inventory.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Anish Panthi
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InventoryDetailsDto implements Serializable {

  private Long id;

  private String itemName;

  private String itemPrice;

  private Integer totalAvailable;

  private Integer totalSold;

  private LocalDateTime createdOn;

  private LocalDateTime updatedOn;

}
