package net.app.inventory.repository;

import net.app.inventory.entity.InventoryTransactions;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Anish Panthi
 */
public interface InventoryTransactionsRepository
    extends JpaRepository<InventoryTransactions, Long> {}
