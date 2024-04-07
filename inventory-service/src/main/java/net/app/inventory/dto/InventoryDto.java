package net.app.inventory.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.math.BigDecimal;

/**
 * @author Anish Panthi
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record InventoryDto(
    Long id,

    String itemName,

    BigDecimal itemPrice,

    int totalAvailable,

    int totalSold) {

}
