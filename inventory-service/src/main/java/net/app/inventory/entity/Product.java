package net.app.inventory.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author Anish Panthi
 */
@Getter
@Setter
@Table(name = "PRODUCT")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Product {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID")
  private Long id;

  @Column(name = "PRODUCT_ID")
  private String productId;

  @Column(name = "NAME")
  private String name;

  @Column(name = "DESCRIPTION")
  private String description;

  @Column(name = "CATEGORY")
  private String category;

  @Column(name = "PRICE")
  private BigDecimal price;

  @Column(name = "CREATED_AT")
  @CreationTimestamp
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
  private LocalDateTime createdAt;

  @Column(name = "UPDATED_AT")
  @UpdateTimestamp
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
  private LocalDateTime updatedAt;
}
