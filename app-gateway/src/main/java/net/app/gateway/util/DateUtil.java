package net.app.gateway.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author Anish Panthi
 */
public class DateUtil {

  private DateUtil() {
  }

  public static String getLocalDateNow() {
    var localDate = LocalDateTime.now();
    var formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS");
    return localDate.format(formatter);
  }
}
