package net.app.authentication.service;

import net.app.authentication.entity.User;
import net.app.authentication.dto.UserDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService extends BaseService<User, UserDto, Long> {
}
