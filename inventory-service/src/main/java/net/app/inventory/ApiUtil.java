package net.app.inventory;

import net.app.inventory.dto.InventoryDto;
import net.app.inventory.dto.ProductDto;
import net.app.inventory.entity.Inventory;
import net.app.inventory.entity.Product;

/**
 * @author Anish Panthi
 */
public class ApiUtil {

  public static InventoryDto convertToDto(Inventory inventory) {
    return new InventoryDto(
        inventory.getId(),
        convertToDto(inventory.getProduct()),
        inventory.getQuantity(),
        inventory.getCreatedAt(),
        inventory.getUpdatedAt());
  }

  public static ProductDto convertToDto(Product product) {
    return new ProductDto(
        product.getId(),
        product.getProductId(),
        product.getName(),
        product.getDescription(),
        product.getCategory(),
        product.getPrice(),
        product.getCreatedAt(),
        product.getUpdatedAt());
  }
}
