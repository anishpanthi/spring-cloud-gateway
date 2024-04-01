package net.app.authentication.repository;

import java.util.Optional;
import net.app.authentication.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Anish Panthi
 */

public interface UserRepository extends JpaRepository<User, Long> {

  Optional<User> findUserByUsername(String username);

}
