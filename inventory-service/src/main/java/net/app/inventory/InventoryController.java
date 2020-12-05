package net.app.inventory;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Anish Panthi
 */
@RestController
@RequestMapping("/v1")
public class InventoryController {

  @GetMapping(value = "/inventories")
  public ResponseEntity<String> sayHello() {
    return new ResponseEntity<>("Hello from inventory-service", HttpStatus.OK);
  }
}
