package net.app.gateway.exception;

import lombok.Getter;

/**
 * @author Anish Panthi
 */
@Getter
public class ApiException extends RuntimeException {

  public ApiException(String message){
    super(message);
  }
}
