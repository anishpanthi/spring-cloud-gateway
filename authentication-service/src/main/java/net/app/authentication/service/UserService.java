package net.app.authentication.service;

import java.util.Optional;
import net.app.authentication.dto.LoginResponse;
import net.app.authentication.entity.User;
import net.app.authentication.dto.UserDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService extends BaseService<User, UserDto, Long> {

  User findUserByUsernameAndPassword(String username, String password);

  Optional<User> findUserByUsername(String username);

  LoginResponse authenticateUser(UserDto userDto);
}
