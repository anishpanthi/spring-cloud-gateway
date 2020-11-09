package net.app.gateway.exception;

import lombok.Getter;

/**
 * @author Anish Panthi
 */
@Getter
public class DataAlreadyExistsException extends RuntimeException{

  public DataAlreadyExistsException(String message){
    super(message);
  }
}
