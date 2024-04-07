package net.app.order.config;

import io.micrometer.observation.ObservationRegistry;
import io.micrometer.observation.aop.ObservedAspect;
import java.math.BigDecimal;
import lombok.RequiredArgsConstructor;
import net.app.order.dto.OrderDto;
import net.app.order.service.OrderService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Anish Panthi
 */
@Configuration
@RequiredArgsConstructor
public class ApiConfig implements CommandLineRunner {

  private final OrderService orderService;

  @Bean
  ObservedAspect observedAspect(ObservationRegistry observationRegistry) {
    return new ObservedAspect(observationRegistry);
  }

  /**
   * @param args
   */
  @Override
  public void run(String... args) {
    if (orderService.findAll().isEmpty()) {
      orderService.create(new OrderDto(null, "Pixel 8 Pro", BigDecimal.valueOf(899.00), 1,
          BigDecimal.valueOf(899.00 * 1)));
    }
  }
}
