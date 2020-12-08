package net.app.authentication.security.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.app.authentication.security.dto.AuthenticatedUser;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

/**
 * @author Anish Panthi
 */
@Component
public class HeaderUtil {

  public void createHeaders(HttpServletRequest request, HttpServletResponse response) {

    AuthenticatedUser authenticatedUser = (AuthenticatedUser) SecurityContextHolder.getContext()
        .getAuthentication().getPrincipal();
    response.setHeader("role", authenticatedUser.getAuthorities().toString());
  }
}
