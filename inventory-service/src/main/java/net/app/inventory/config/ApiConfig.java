package net.app.inventory.config;

import io.micrometer.observation.ObservationRegistry;
import io.micrometer.observation.aop.ObservedAspect;
import java.math.BigDecimal;
import lombok.RequiredArgsConstructor;
import net.app.inventory.dto.InventoryDto;
import net.app.inventory.service.InventoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Anish Panthi
 */
@Configuration
@RequiredArgsConstructor
public class ApiConfig implements CommandLineRunner {

  private final InventoryService inventoryService;

  @Override
  public void run(String... args) throws Exception {
    if (inventoryService.findAll().isEmpty()) {
      inventoryService.create(
          new InventoryDto(null, "Pixel 8 Pro", BigDecimal.valueOf(899.00), 100, 4));
    }
  }

  @Bean
  ObservedAspect observedAspect(ObservationRegistry observationRegistry) {
    return new ObservedAspect(observationRegistry);
  }
}
