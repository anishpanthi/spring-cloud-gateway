package net.app.inventory.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

/**
 * @author Anish Panthi
 */
@Getter
@Setter
@Table(name = "INVENTORY_TRANSACTIONS")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class InventoryTransactions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "PRODUCT_ID")
    private String productId;

    @Column(name = "TRANSACTION_TYPE")
    private String transactionType; // "INCREASE" or "DECREASE"

    @Column(name = "QUANTITY")
    private Integer quantity;

    @Column(name = "ORDER_ID")
    private Integer orderId; // Nullable, can be linked to an order

    @Column(name = "TRANSACTION_AT")
    @CreationTimestamp
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime transactionAt;

    @Column(name = "UPDATED_AT")
    @UpdateTimestamp
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updatedAt;
}
