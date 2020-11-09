package net.app.gateway.repository;

import java.util.Optional;
import net.app.gateway.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Anish Panthi
 */

public interface UserRepository extends JpaRepository<User, Long> {

  User findByUsernameOrEmail(String username, String email);

  Optional<User> findByUsername(String username);

  User findByUsernameAndPassword(String username, String password);

  Page<User> findAll(Pageable pageable);
}
