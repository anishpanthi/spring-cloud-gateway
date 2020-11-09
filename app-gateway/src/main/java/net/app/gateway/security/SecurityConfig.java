package net.app.gateway.security;

import java.util.Arrays;
import java.util.Collections;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @author Anish Panthi
 */
@Configuration
@EnableWebSecurity
@EnableAutoConfiguration
@EnableGlobalMethodSecurity(prePostEnabled = true, proxyTargetClass = true)
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  private JwtAuthenticationEntryPoint unauthorizedHandler;

  private JwtAuthenticationProvider authenticationProvider;

  @Bean
  @Override
  public AuthenticationManager authenticationManager() throws Exception {
    return new ProviderManager(Collections.singletonList(authenticationProvider));
  }

  @Bean
  public JwtAuthenticationTokenFilter authenticationTokenFilterBean() throws Exception {
    JwtAuthenticationTokenFilter authenticationTokenFilter = new JwtAuthenticationTokenFilter();
    authenticationTokenFilter.setAuthenticationManager(authenticationManager());
    authenticationTokenFilter.setAuthenticationSuccessHandler(new JwtAuthenticationSuccessHandler());
    return authenticationTokenFilter;
  }

  @Override
  protected void configure(HttpSecurity httpSecurity) throws Exception {
    httpSecurity
        .cors().and()
        // we don't need CSRF because our token is invulnerable
        .csrf().disable()
        // permit swagger, console, auth and dashboard for all
        .authorizeRequests().antMatchers( "/swagger-ui.html", "/auth", "/*.html",
        "/**/*.css", "/**/*.js", "/v2/api-docs", "/api-docs", "/configuration/ui",
        "/swagger-resources", "/configuration/security", "/favicon.ico", "/**/*.html",
        "/webjars/**", "/swagger-resources/configuration/security",
        "/swagger-resources/configuration/ui")
        .permitAll().and()
        // All others urls must be authenticated (filter for token always fires)
        .authorizeRequests().antMatchers("/**").authenticated().and()
        // Call our errorHandler if authentication/authorisation fails
        .exceptionHandling().authenticationEntryPoint(unauthorizedHandler);
    // don't create session
    httpSecurity.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    // Custom JWT based security filter
    httpSecurity.addFilterBefore(authenticationTokenFilterBean(), UsernamePasswordAuthenticationFilter.class);
    // disable page caching
    httpSecurity.headers().cacheControl();
  }
}
