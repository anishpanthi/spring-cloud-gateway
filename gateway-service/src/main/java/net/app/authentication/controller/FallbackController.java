package net.app.authentication.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Anish Panthi
 */
@RestController
public class FallbackController {

  @GetMapping("/fallback/order")
  public ResponseEntity<String> orderFallback() {
    return ResponseEntity.ok(
        "Order Service is taking too long to respond or is down. Please try again later.");
  }

  @GetMapping("/fallback/inventory")
  public ResponseEntity<String> inventoryFallback() {
    return ResponseEntity.ok(
        "Inventory Service is taking too long to respond or is down. Please try again later.");
  }

}
