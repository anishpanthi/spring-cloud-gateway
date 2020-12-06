package net.app.order.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.app.order.dto.ApiResponse;
import net.app.order.dto.OrderDetailsDto;
import net.app.order.entity.OrderDetails;
import net.app.order.repository.OrderDetailsRepository;
import net.app.order.service.OrderDetailsService;
import org.apache.http.HttpStatus;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * Implementation for OrderDetails
 *
 * @author Anish Panthi
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class OrderDetailsServiceImpl implements OrderDetailsService {

  private final OrderDetailsRepository orderDetailsRepository;

  @Override
  public Optional<OrderDetailsDto> findOne(Long aLong) {
    var orderDetailsOptional = orderDetailsRepository.findById(aLong);
    return orderDetailsOptional.map(this::convertToDto);
  }

  @Override
  public List<OrderDetails> findAll() {
    return orderDetailsRepository.findAll();
  }

  @Override
  public OrderDetailsDto create(OrderDetailsDto orderDetailsDto) {
    var orderDetails = new OrderDetails();
    BeanUtils.copyProperties(orderDetailsDto, orderDetails);
    orderDetailsRepository.save(orderDetails);
    return convertToDto(orderDetails);
  }

  @Override
  public ApiResponse delete(OrderDetailsDto orderDetailsDto) {
    orderDetailsRepository.delete(convertToEntity(orderDetailsDto));
    return createApiResponse();
  }

  @Override
  public OrderDetailsDto update(OrderDetailsDto orderDetailsDto) {
    create(orderDetailsDto);
    return orderDetailsDto;
  }

  @Override
  public Page<OrderDetailsDto> findAll(Pageable pageable) {
    var orderDetailsPage = orderDetailsRepository.findAll(pageable);
    return orderDetailsPage.map(this::convertToDto);
  }

  private OrderDetailsDto convertToDto(OrderDetails orderDetails){
    var orderDetailsDto = new OrderDetailsDto();
    BeanUtils.copyProperties(orderDetails, orderDetailsDto);
    return orderDetailsDto;
  }

  private OrderDetails convertToEntity(OrderDetailsDto orderDetailsDto){
    var orderDetails = new OrderDetails();
    BeanUtils.copyProperties(orderDetailsDto, orderDetails);
    return orderDetails;
  }

  private ApiResponse createApiResponse(){
    return ApiResponse.builder().apiMessage("Record Deleted!").status("SUCCESS").timeStamp(
        LocalDateTime.now()).build();
  }
}
