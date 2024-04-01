package net.app.authentication.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author Anish Panthi
 */
@Configuration
@EnableJpaRepositories(basePackages = "net.app.authentication.repository")
@EntityScan(basePackages = "net.app.authentication.entity")
public class DatabaseConfig {

}
