package net.app.inventory.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import net.app.inventory.dto.ProductDto;
import net.app.inventory.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Anish Panthi
 */
@Service
@Log4j2
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

  @Override
  public Optional<ProductDto> findOne(Long aLong) {
    return Optional.empty();
  }

  @Override
  public List<ProductDto> findAll() {
    return List.of();
  }

  @Override
  public ProductDto create(ProductDto productDto) {
    return null;
  }

  @Override
  public void delete(Long aLong) {}

  @Override
  public ProductDto update(ProductDto productDto) {
    return null;
  }

  @Override
  public Page<ProductDto> findAll(Pageable pageable) {
    return ProductService.super.findAll(pageable);
  }
}
