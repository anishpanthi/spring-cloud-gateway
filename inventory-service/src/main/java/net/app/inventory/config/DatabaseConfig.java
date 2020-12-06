package net.app.inventory.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author Anish Panthi
 */
@Configuration
@EnableJpaRepositories(basePackages = "net.app.inventory.repository")
@EntityScan(basePackages = "net.app.inventory.entity")
public class DatabaseConfig {

}
