package net.app.inventory.repository;

import net.app.inventory.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Anish Panthi
 */
public interface InventoryRepository extends JpaRepository<Inventory, Long> {

}
