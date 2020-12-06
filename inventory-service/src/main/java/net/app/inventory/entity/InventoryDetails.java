package net.app.inventory.entity;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.domain.Persistable;

/**
 * @author Anish Panthi
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "INVENTORY_DETAILS")
public class InventoryDetails implements Persistable<Long> {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "INVENTORY_ID")
  private Long id;

  @Column(name = "ITEM_NAME")
  private String itemName;

  @Column(name = "ITEM_PRICE")
  private String itemPrice;

  @Column(name = "TOTAL_AVAILABLE")
  private Integer totalAvailable;

  @Column(name = "TOTAL_SOLD")
  private Integer totalSold;

  @Column(name = "CREATED_ON")
  @CreationTimestamp
  private LocalDateTime createdOn;

  @Column(name = "UPDATED_ON")
  @UpdateTimestamp
  private LocalDateTime updatedOn;

  /**
   * Returns if the {@code Persistable} is new or was persisted already.
   *
   * @return if {@literal true} the object is new.
   */
  @Override
  public boolean isNew() {
    return true;
  }
}
