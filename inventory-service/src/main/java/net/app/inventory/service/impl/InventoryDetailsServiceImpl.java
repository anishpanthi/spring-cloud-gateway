package net.app.inventory.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.app.inventory.dto.ApiResponse;
import net.app.inventory.dto.InventoryDetailsDto;
import net.app.inventory.entity.InventoryDetails;
import net.app.inventory.repository.InventoryDetailsRepository;
import net.app.inventory.service.InventoryDetailsService;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * @author Anish Panthi
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class InventoryDetailsServiceImpl implements InventoryDetailsService {

  private final InventoryDetailsRepository inventoryDetailsRepository;

  @Override
  public Optional<InventoryDetailsDto> findOne(Long aLong) {
    var inventoryDetailsOptional = inventoryDetailsRepository.findById(aLong);
    return inventoryDetailsOptional.map(this::convertToDto);
  }

  @Override
  public List<InventoryDetails> findAll() {
    return inventoryDetailsRepository.findAll();
  }

  @Override
  public InventoryDetailsDto create(InventoryDetailsDto inventoryDetailsDto) {
    var inventoryDetails = new InventoryDetails();
    BeanUtils.copyProperties(inventoryDetailsDto, inventoryDetails);
    inventoryDetailsRepository.save(inventoryDetails);
    return convertToDto(inventoryDetails);
  }

  @Override
  public ApiResponse delete(InventoryDetailsDto inventoryDetailsDto) {
    inventoryDetailsRepository.delete(convertToEntity(inventoryDetailsDto));
    return createApiResponse();
  }

  @Override
  public InventoryDetailsDto update(InventoryDetailsDto inventoryDetailsDto) {
    create(inventoryDetailsDto);
    return inventoryDetailsDto;
  }

  @Override
  public Page<InventoryDetailsDto> findAll(Pageable pageable) {
    var inventoryDetailsPage = inventoryDetailsRepository.findAll(pageable);
    return inventoryDetailsPage.map(this::convertToDto);
  }

  private InventoryDetailsDto convertToDto(InventoryDetails inventoryDetails) {
    var inventoryDetailsDto = new InventoryDetailsDto();
    BeanUtils.copyProperties(inventoryDetails, inventoryDetailsDto);
    return inventoryDetailsDto;
  }

  private InventoryDetails convertToEntity(InventoryDetailsDto inventoryDetailsDto) {
    var inventoryDetails = new InventoryDetails();
    BeanUtils.copyProperties(inventoryDetailsDto, inventoryDetails);
    return inventoryDetails;
  }

  private ApiResponse createApiResponse() {
    return ApiResponse.builder().apiMessage("Record Deleted!").status("SUCCESS").timeStamp(
        LocalDateTime.now()).build();
  }
}
