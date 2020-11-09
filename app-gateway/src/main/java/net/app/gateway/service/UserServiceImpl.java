package net.app.gateway.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.app.gateway.domain.User;
import net.app.gateway.dto.UserDto;
import net.app.gateway.exception.ApiException;
import net.app.gateway.exception.DataAlreadyExistsException;
import net.app.gateway.exception.NotFoundException;
import net.app.gateway.repository.UserRepository;
import net.app.gateway.util.Constants;
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
  public List<UserDto> findAll() throws ApiException {
    List<User> usersInDb;
    try {
      usersInDb = userRepository.findAll();
      if (usersInDb.isEmpty()) {
        throw new NotFoundException("Record Not Found!!!");
      }
    } catch (Exception e) {
      throw new ApiException(e.getMessage());
    }

    List<UserDto> userDtoList = new ArrayList<>();

    usersInDb.forEach(user -> {
          UserDto userDto = new UserDto();
          BeanUtils.copyProperties(user, userDto);
          userDtoList.add(userDto);
        }
    );
    return userDtoList;
  }

  @Override
  public Page<User> findAll(Pageable pageable) {
    Page<User> userPage;
    try {
      log.info("{}", pageable);
      userPage = userRepository.findAll(pageable);
      log.info("userPage:: {}", userPage.toString());
    } catch (Exception e) {
      log.error("", e);
      throw new ApiException(e.getMessage());
    }
    return userPage;
  }

  @Override
  public UserDto findOne(Long id) throws ApiException {
    UserDto userDto = new UserDto();
    try {
      Optional<User> user = userRepository.findById(id);
      if (user.isEmpty()) {
        throw new NotFoundException("Record Not Found By Given Id!!!");
      }
      BeanUtils.copyProperties(user.get(), userDto);
    } catch (Exception e) {
      throw new ApiException(e.getMessage());
    }
    return userDto;
  }

  @Override
  public Object save(UserDto userDto) throws ApiException {
    try {
      User userInDb = userRepository
          .findByUsernameOrEmail(userDto.getUsername(), userDto.getEmail());
      if (userInDb != null) {
        throw new DataAlreadyExistsException(
            userDto.getUsername() + "/" + userDto.getEmail() + " already exists!!!");
      }
    } catch (Exception e) {
      throw new ApiException(e.getMessage());
    }
    return saveOrUpdate(userDto, Constants.SAVE);
  }

  @Override
  public Object update(UserDto userDto) throws ApiException {
    try {
      Optional<User> userInDb = userRepository.findById(userDto.getId());
      if (userInDb.isEmpty()) {
        throw new DataAlreadyExistsException(
            "Unable to find " + userDto.getId() + " to update. User doesn't exists!!!");
      }
    } catch (Exception e) {
      throw new ApiException(e.getMessage());
    }
    return saveOrUpdate(userDto, Constants.UPDATE);
  }

  @Override
  public Object delete(UserDto userDto) throws ApiException {
    try {
      Optional<User> userInDb = userRepository.findById(userDto.getId());
      if (userInDb.isEmpty()) {
        throw new DataAlreadyExistsException(
            "Unable to find " + userDto.getId() + " to delete. User doesn't exists!!!");
      }
      User user = new User();
      BeanUtils.copyProperties(userDto, user);
      userRepository.delete(user);
    } catch (Exception e) {
      throw new ApiException(e.getMessage());
    }
    return prepareSuccessCrudStatusDto(Constants.DELETE);
  }

  @Override
  public Optional<User> findByUsername(String username) {
    Optional<User> userOptional = Optional.empty();
    try {
      userOptional = userRepository.findByUsername(username);
    } catch (Exception e) {
      log.error("", e);
    }
    return userOptional;
  }

  @Override
  public User findByUsernameAndPassword(String username, String password) {
    User userInDb;
    try {
      userInDb = userRepository.findByUsernameAndPassword(username, password);
      if (userInDb == null) {
        throw new NotFoundException("Username or Password mismatched!!!");
      }
    } catch (Exception e) {
      log.error("", e);
      throw new ApiException(e.getMessage());
    }
    return userInDb;
  }

  private Object saveOrUpdate(UserDto userDto, String operation) throws ApiException {
    try {
      User user = new User();
      BeanUtils.copyProperties(userDto, user);
      userRepository.save(user);
    } catch (Exception e) {
      log.error("", e);
      throwCrudError(operation);
    }
    return prepareSuccessCrudStatusDto(operation);
  }
}