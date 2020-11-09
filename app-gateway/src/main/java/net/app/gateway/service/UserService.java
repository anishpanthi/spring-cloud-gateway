package net.app.gateway.service;

import net.app.gateway.domain.User;
import net.app.gateway.dto.UserDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService extends BaseService<User, UserDto, Long> {

  User findByUsernameAndPassword(String username, String password);

  Page<User> findAll(Pageable pageable);
}
