//package net.app.authentication.exception.handler;
//
//import java.time.LocalDateTime;
//import net.app.authentication.dto.ApiResponse;
//import net.app.authentication.exception.NotFoundException;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
//
///**
// * @author Anish Panthi
// */
//@RestControllerAdvice
//public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
//
//  @ExceptionHandler(NotFoundException.class)
//  public ResponseEntity<ApiResponse> handleNotFoundException(NotFoundException nfe){
//    return new ResponseEntity<>(generateErrorResponse(nfe.getMessage()), HttpStatus.NOT_FOUND);
//  }
//
//  @ExceptionHandler(AuthenticationException.class)
//  public ResponseEntity<ApiResponse> handleAuthenticationException(AuthenticationException ae){
//    return new ResponseEntity<>(generateErrorResponse(ae.getMessage()), HttpStatus.UNAUTHORIZED);
//  }
//
//  private ApiResponse generateErrorResponse(String message){
//    var apiErrorResponse = new ApiResponse();
//    apiErrorResponse.setTimeStamp(LocalDateTime.now());
//    apiErrorResponse.setStatus("ERROR");
//    apiErrorResponse.setMessage(message);
//    return apiErrorResponse;
//  }
//
//}
