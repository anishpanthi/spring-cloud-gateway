package net.app.order.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.math.BigDecimal;

/**
 * @author Anish Panthi
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record OrderDto(
    Long id,
    String itemName,
    BigDecimal itemPrice,
    int totalQuantity,
    BigDecimal totalAmount) { }
