package net.app.inventory.repository;

import net.app.inventory.entity.InventoryDetails;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Anish Panthi
 */
public interface InventoryDetailsRepository extends JpaRepository<InventoryDetails, Long> {

}
