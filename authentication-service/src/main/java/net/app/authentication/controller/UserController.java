package net.app.authentication.controller;

import lombok.RequiredArgsConstructor;
import net.app.authentication.dto.ApiResponse;
import net.app.authentication.dto.UserDto;
import net.app.authentication.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Anish Panthi
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1")
public class UserController {

  private final UserService userService;

  @GetMapping(value = "/users")
  public ResponseEntity<Page<UserDto>> getUsers(Pageable pageable) {
    return new ResponseEntity<>(userService.findAll(pageable), HttpStatus.OK);
  }

  @PostMapping(value = "/users", consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<UserDto> createUsers(
      @RequestBody UserDto userDto) {
    return new ResponseEntity<>(userService.create(userDto), HttpStatus.OK);
  }

  @PutMapping(value = "/users", consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<UserDto> updateUsers(
      @RequestBody UserDto userDto) {
    return new ResponseEntity<>(userService.update(userDto), HttpStatus.OK);
  }

  @DeleteMapping(value = "/users", consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<ApiResponse> deleteUsers(
      @RequestBody UserDto userDto) {
    return new ResponseEntity<>(userService.delete(userDto), HttpStatus.OK);

  }
}
