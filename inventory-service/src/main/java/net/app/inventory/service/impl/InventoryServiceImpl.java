package net.app.inventory.service.impl;

import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import net.app.inventory.dto.InventoryDto;
import net.app.inventory.entity.Inventory;
import net.app.inventory.exception.NotFoundException;
import net.app.inventory.repository.InventoryRepository;
import net.app.inventory.service.InventoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * @author Anish Panthi
 */
@Service
@Log4j2
@RequiredArgsConstructor
public class InventoryServiceImpl implements InventoryService {

  private final InventoryRepository inventoryRepository;

  @Override
  public Optional<InventoryDto> findOne(Long aLong) {
    var inventoryOptional = inventoryRepository.findById(aLong);
    log.info("Inventory details: {}",
        inventoryOptional.orElseThrow(() -> new NotFoundException("Inventory not found.")));
    return inventoryOptional.map(this::convertToDto);
  }

  @Override
  public List<Inventory> findAll() {
    return inventoryRepository.findAll();
  }

  @Override
  public InventoryDto create(InventoryDto inventoryDto) {
    var inventory = new Inventory();
    BeanUtils.copyProperties(inventoryDto, inventory);
    inventoryRepository.save(inventory);
    log.info("Inventory created: {}", inventory);
    return convertToDto(inventory);
  }

  @Override
  public void delete(Long id) {
    inventoryRepository.deleteById(id);
    log.info("Inventory deleted with id: {}", id);
  }

  @Override
  public InventoryDto update(InventoryDto inventoryDto) {
    if (inventoryDto.id() == null || findOne(inventoryDto.id()).isEmpty()) {
      throw new NotFoundException("Inventory id is not found.");
    }
    create(inventoryDto);
    log.info("Inventory updated: {}", inventoryDto);
    return inventoryDto;
  }

  @Override
  public Page<InventoryDto> findAll(Pageable pageable) {
    var inventoryPage = inventoryRepository.findAll(pageable);
    log.info("Total inventories found: {}", inventoryPage.getTotalElements());
    return inventoryPage.map(this::convertToDto);
  }

  private InventoryDto convertToDto(Inventory inventory) {
    return new InventoryDto(inventory.getId(), inventory.getItemName(),
        inventory.getItemPrice(), inventory.getTotalAvailable(), inventory.getTotalSold());
  }
}
