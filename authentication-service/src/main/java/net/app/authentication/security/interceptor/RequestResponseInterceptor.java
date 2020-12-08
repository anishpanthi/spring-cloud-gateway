package net.app.authentication.security.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import net.app.authentication.security.util.HeaderUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * @author Anish Panthi
 */
@Component
@RequiredArgsConstructor
public class RequestResponseInterceptor extends HandlerInterceptorAdapter {

  private final HeaderUtil headerUtil;

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
      throws Exception {
    headerUtil.createHeaders(request, response);
    return super.preHandle(request, response, handler);
  }
}
