package net.app.order.controller;

import io.micrometer.observation.annotation.Observed;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import net.app.order.dto.OrderDto;
import net.app.order.service.OrderService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Anish Panthi
 */
@RestController
@RequestMapping("/v1/orders")
@RequiredArgsConstructor
public class OrderController {

  private final OrderService orderService;

  @Observed(name = "get.orders", contextualName = "get-all-orders")
  @GetMapping
  public ResponseEntity<Page<OrderDto>> getOrders(Pageable pageable) {
    return new ResponseEntity<>(orderService.findAll(pageable), HttpStatus.OK);
  }

  @Observed(name = "get.single.order", contextualName = "get-single-order")
  @GetMapping("/{id}")
  public ResponseEntity<Optional<OrderDto>> getSingleOrder(@PathVariable Long id) {
    return new ResponseEntity<>(orderService.findOne(id), HttpStatus.OK);
  }

  @Observed(name = "create.orders", contextualName = "create-orders")
  @PostMapping
  public ResponseEntity<OrderDto> createOrders(
      @RequestBody OrderDto orderDto) {
    return new ResponseEntity<>(orderService.create(orderDto), HttpStatus.OK);
  }

  @Observed(name = "update.orders", contextualName = "update-orders")
  @PutMapping
  public ResponseEntity<OrderDto> updateOrders(
      @RequestBody OrderDto orderDto) {
    return new ResponseEntity<>(orderService.update(orderDto), HttpStatus.OK);
  }

  @Observed(name = "delete.orders", contextualName = "delete-orders")
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteOrders(@PathVariable Long id) {
    orderService.delete(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
