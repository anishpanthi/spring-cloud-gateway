package net.app.authentication.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.app.authentication.dto.ApiResponse;
import net.app.authentication.dto.UserDto;
import net.app.authentication.entity.User;
import net.app.authentication.repository.UserRepository;
import net.app.authentication.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * @author Anish Panthi
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;

  @Override
  public Optional<UserDto> findOne(Long aLong) {
    var userOptional = userRepository.findById(aLong);
    return userOptional.map(this::convertToDto);
  }

  @Override
  public List<User> findAll() {
    return userRepository.findAll();
  }

  @Override
  public UserDto create(UserDto userDto) {
    var user = new User();
    BeanUtils.copyProperties(userDto, user);
    userRepository.save(user);
    return convertToDto(user);
  }

  @Override
  public ApiResponse delete(UserDto userDto) {
    userRepository.delete(convertToEntity(userDto));
    return createApiResponse();
  }

  @Override
  public UserDto update(UserDto userDto) {
    create(userDto);
    return userDto;
  }

  @Override
  public Page<UserDto> findAll(Pageable pageable) {
    var userPage = userRepository.findAll(pageable);
    return userPage.map(this::convertToDto);
  }

  private UserDto convertToDto(User user) {
    var userDto = new UserDto();
    BeanUtils.copyProperties(user, userDto);
    return userDto;
  }

  private User convertToEntity(UserDto userDto) {
    var user = new User();
    BeanUtils.copyProperties(userDto, user);
    return user;
  }

  private ApiResponse createApiResponse() {
    return ApiResponse.builder().apiMessage("Record Deleted!").status("SUCCESS").timeStamp(
        LocalDateTime.now()).build();
  }
}
