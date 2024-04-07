package net.app.inventory.controller;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import net.app.inventory.dto.InventoryDto;
import net.app.inventory.service.InventoryService;
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
@RequestMapping("/v1/inventory")
@RequiredArgsConstructor
public class InventoryController {

  private final InventoryService inventoryService;

  @GetMapping
  public ResponseEntity<Page<InventoryDto>> getInventories(Pageable pageable) {
    return new ResponseEntity<>(inventoryService.findAll(pageable), HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Optional<InventoryDto>> getInventories(@PathVariable Long id) {
    return new ResponseEntity<>(inventoryService.findOne(id), HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<InventoryDto> createInventories(
      @RequestBody InventoryDto inventoryDto) {
    return new ResponseEntity<>(inventoryService.create(inventoryDto), HttpStatus.CREATED);
  }

  @PutMapping
  public ResponseEntity<InventoryDto> updateInventories(
      @RequestBody InventoryDto inventoryDto) {
    return new ResponseEntity<>(inventoryService.update(inventoryDto), HttpStatus.NO_CONTENT);
  }

  @DeleteMapping(value = "/{id}}")
  public ResponseEntity<Void> deleteInventories(@PathVariable Long id) {
    inventoryService.delete(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
