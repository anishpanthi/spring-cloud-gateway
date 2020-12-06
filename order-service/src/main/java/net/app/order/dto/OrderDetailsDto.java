package net.app.order.dto;

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
public class OrderDetailsDto implements Serializable {

  private Long id;

  private String itemName;

  private Double itemPrice;

  private Integer totalQuantity;

  private Double totalAmount;

  private LocalDateTime createdOn;

  private LocalDateTime updatedOn;

  public Double getTotalAmount() {
    return this.itemPrice * this.totalQuantity;
  }
}
