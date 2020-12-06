package net.app.authentication.repository;

import net.app.authentication.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Anish Panthi
 */

public interface UserRepository extends JpaRepository<User, Long> {

}
