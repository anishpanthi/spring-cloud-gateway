package net.app.inventory.service.impl;

import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import net.app.inventory.ApiUtil;
import net.app.inventory.dto.ProductDto;
import net.app.inventory.entity.Product;
import net.app.inventory.exception.NotFoundException;
import net.app.inventory.repository.ProductRepository;
import net.app.inventory.service.ProductService;
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
public class ProductServiceImpl implements ProductService {

  private final ProductRepository productRepository;

  @Override
  public Optional<ProductDto> findOne(Long aLong) {
    var productOptional = productRepository.findById(aLong);
    log.debug(
        "Product details: {}",
        productOptional.orElseThrow(() -> new NotFoundException("Product not found.")));
    return productOptional.map(ApiUtil::convertToDto);
  }

  @Override
  public List<ProductDto> findAll() {
    return productRepository.findAll().stream().map(ApiUtil::convertToDto).toList();
  }

  @Override
  public ProductDto create(ProductDto productDto) {
    var product = new Product();
    BeanUtils.copyProperties(productDto, product);
    var savedProduct = productRepository.save(product);
    log.debug("Product created: {}", savedProduct);
    return ApiUtil.convertToDto(savedProduct);
  }

  @Override
  public void delete(Long aLong) {
    productRepository.deleteById(aLong);
    log.info("Product deleted with id: {}", aLong);
  }

  @Override
  public ProductDto update(ProductDto productDto) {
    if (productDto == null || findOne(productDto.id()).isEmpty()) {
      throw new NotFoundException("Product id is not found.");
    }
    var updatedProduct = create(productDto);
    log.debug("Product updated: {}", updatedProduct);
    return updatedProduct;
  }

  @Override
  public Page<ProductDto> findAll(Pageable pageable) {
    var productPage = productRepository.findAll(pageable);
    log.info("Total products found: {}", productPage.getTotalElements());
    return productPage.map(ApiUtil::convertToDto);
  }
}
