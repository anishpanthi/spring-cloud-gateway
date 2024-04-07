package net.app.inventory.exception;

/**
 * @author Anish Panthi
 */
public class NotFoundException extends RuntimeException {

  public NotFoundException(String message) {
    super(message);
  }
}
