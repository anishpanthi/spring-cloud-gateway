package net.app.inventory.repository;

import net.app.inventory.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Anish Panthi
 */
public interface ProductRepository extends JpaRepository<Product, Long> {}
