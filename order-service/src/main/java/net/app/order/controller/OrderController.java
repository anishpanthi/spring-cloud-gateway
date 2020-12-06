package net.app.order.controller;

import lombok.RequiredArgsConstructor;
import net.app.order.dto.ApiResponse;
import net.app.order.dto.OrderDetailsDto;
import net.app.order.service.OrderDetailsService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Anish Panthi
 */
@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class OrderController {

  private final OrderDetailsService orderDetailsService;

  @GetMapping(value = "/orderDetails", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Page<OrderDetailsDto>> getOrders(Pageable pageable) {
    return new ResponseEntity<>(orderDetailsService.findAll(pageable), HttpStatus.OK);
  }

  @PostMapping(value = "/orderDetails", consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<OrderDetailsDto> createOrders(
      @RequestBody OrderDetailsDto orderDetailsDto) {
    return new ResponseEntity<>(orderDetailsService.create(orderDetailsDto), HttpStatus.OK);
  }

  @PutMapping(value = "/orderDetails", consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<OrderDetailsDto> updateOrders(
      @RequestBody OrderDetailsDto orderDetailsDto) {
    return new ResponseEntity<>(orderDetailsService.update(orderDetailsDto), HttpStatus.OK);
  }

  @DeleteMapping(value = "/orderDetails", consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<ApiResponse> deleteOrders(
      @RequestBody OrderDetailsDto orderDetailsDto) {
    return new ResponseEntity<>(orderDetailsService.delete(orderDetailsDto), HttpStatus.OK);
  }
}
