//package net.app.authentication.security.config;
//
//import java.util.Collections;
//import lombok.RequiredArgsConstructor;
//import net.app.authentication.security.JwtAuthenticationEntryPoint;
//import net.app.authentication.security.JwtAuthenticationProvider;
//import net.app.authentication.security.JwtAuthenticationSuccessHandler;
//import net.app.authentication.security.JwtAuthenticationTokenFilter;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.ProviderManager;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
///**
// * @author Anish Panthi
// */
//@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true, proxyTargetClass = true)
//@RequiredArgsConstructor
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//  private final JwtAuthenticationEntryPoint unauthorizedHandler;
//
//  private final JwtAuthenticationProvider authenticationProvider;
//
//  @Bean
//  @Override
//  protected AuthenticationManager authenticationManager() throws Exception {
//    return new ProviderManager(Collections.singletonList(authenticationProvider));
//  }
//
//  public JwtAuthenticationTokenFilter authenticationTokenFilterBean() throws Exception {
//    JwtAuthenticationTokenFilter authenticationTokenFilter = new JwtAuthenticationTokenFilter();
//    authenticationTokenFilter.setAuthenticationManager(authenticationManager());
//    authenticationTokenFilter
//        .setAuthenticationSuccessHandler(new JwtAuthenticationSuccessHandler());
//    return authenticationTokenFilter;
//  }
//
//  @Override
//  protected void configure(HttpSecurity httpSecurity) throws Exception {
//    httpSecurity
//        .cors().and()
//        .csrf().disable()
//        .authorizeRequests().antMatchers("/**")
//        .permitAll().and()
////        .authorizeRequests().antMatchers("/v1/**").authenticated().and()
//        .exceptionHandling().authenticationEntryPoint(unauthorizedHandler);
//    httpSecurity.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//    httpSecurity.addFilterBefore(authenticationTokenFilterBean(),
//        UsernamePasswordAuthenticationFilter.class);
//    httpSecurity.headers().cacheControl();
//  }
//}
