package net.app.gateway.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author Anish Panthi
 */
@Configuration
@EnableJpaRepositories(basePackages = "net.app.gateway.repository")
@EntityScan(basePackages = "net.app.gateway.domain")
public class DatabaseConfig {

}
