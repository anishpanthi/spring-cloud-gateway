//package net.app.authentication.controller;
//
//import lombok.RequiredArgsConstructor;
//import net.app.authentication.dto.LoginResponse;
//import net.app.authentication.dto.UserDto;
//import net.app.authentication.service.UserService;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
///**
// * @author Anish Panthi
// */
//@RestController
//@RequiredArgsConstructor
//@RequestMapping("/authN")
//public class AuthenticationController {
//
//  private final UserService userService;
//
//  @PostMapping(value = "/user", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//  public ResponseEntity<LoginResponse> authenticateUser(@RequestBody UserDto userDto){
//
//    return new ResponseEntity<>(userService.authenticateUser(userDto), HttpStatus.OK);
//  }
//
//}
