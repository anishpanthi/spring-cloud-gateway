package net.app.order.repository;

import net.app.order.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Anish Panthi
 */
public interface OrderRepository extends JpaRepository<Order, Long> {

}
