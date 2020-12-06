package net.app.inventory.controller;

import lombok.RequiredArgsConstructor;
import net.app.inventory.dto.ApiResponse;
import net.app.inventory.dto.InventoryDetailsDto;
import net.app.inventory.service.InventoryDetailsService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
public class InventoryController {

  private final InventoryDetailsService inventoryDetailsService;

  @GetMapping(value = "/inventoryDetails")
  public ResponseEntity<Page<InventoryDetailsDto>> getInventories(Pageable pageable) {
    return new ResponseEntity<>(inventoryDetailsService.findAll(pageable), HttpStatus.OK);
  }

  @PostMapping(value = "/inventoryDetails", consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<InventoryDetailsDto> createInventories(
      @RequestBody InventoryDetailsDto inventoryDetailsDto) {
    return new ResponseEntity<>(inventoryDetailsService.create(inventoryDetailsDto), HttpStatus.OK);
  }

  @PutMapping(value = "/inventoryDetails", consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<InventoryDetailsDto> updateInventories(
      @RequestBody InventoryDetailsDto inventoryDetailsDto) {
    return new ResponseEntity<>(inventoryDetailsService.update(inventoryDetailsDto), HttpStatus.OK);
  }

  @PostMapping(value = "/inventoryDetails", consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<ApiResponse> deleteInventories(
      @RequestBody InventoryDetailsDto inventoryDetailsDto) {
    return new ResponseEntity<>(inventoryDetailsService.delete(inventoryDetailsDto), HttpStatus.OK);
  }
}
