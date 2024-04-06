package net.app.order.service.impl;

import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.app.order.dto.OrderDto;
import net.app.order.entity.Order;
import net.app.order.exception.NotFoundException;
import net.app.order.repository.OrderRepository;
import net.app.order.service.OrderService;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * Implementation for Order
 *
 * @author Anish Panthi
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class OrderServiceImpl implements OrderService {

  private final OrderRepository orderRepository;

  @Override
  public Optional<OrderDto> findOne(Long aLong) {
    var orderOptional = orderRepository.findById(aLong);
    log.info("Order found: {}",
        orderOptional.orElseThrow(() -> new NotFoundException("Order not found")));
    return orderOptional.map(this::convertToDto);
  }

  @Override
  public List<Order> findAll() {
    return orderRepository.findAll();
  }

  @Override
  public OrderDto create(OrderDto orderDto) {
    var order = new Order();
    BeanUtils.copyProperties(orderDto, order);
    orderRepository.save(order);
    log.info("Order created: {}", order);
    return convertToDto(order);
  }

  @Override
  public void delete(Long id) {
    orderRepository.deleteById(id);
    log.info("Order deleted with id: {}", id);
  }

  @Override
  public OrderDto update(OrderDto orderDto) {
    if (orderDto.id() == null || findOne(orderDto.id()).isEmpty()) {
      throw new NotFoundException("Order id is not found");
    }
    create(orderDto);
    log.info("Order updated: {}", orderDto);
    return orderDto;
  }

  @Override
  public Page<OrderDto> findAll(Pageable pageable) {
    var orderPage = orderRepository.findAll(pageable);
    log.info("Total Orders found: {}", orderPage.getTotalElements());
    return orderPage.map(this::convertToDto);
  }

  private OrderDto convertToDto(Order order) {
    return new OrderDto(order.getId(), order.getItemName(), order.getItemPrice(),
        order.getTotalQuantity(), order.getTotalAmount());
  }
}
