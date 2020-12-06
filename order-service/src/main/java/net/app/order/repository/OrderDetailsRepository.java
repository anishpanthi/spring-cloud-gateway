package net.app.order.repository;

import net.app.order.entity.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Anish Panthi
 */
public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Long> {

}
