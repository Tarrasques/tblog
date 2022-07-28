package com.tblog.tlog.comfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

//    @Autowired
//    private UserDetailsService service;
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//       auth.userDetailsService(service);
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.cors().disable();
//        http.csrf().and().authorizeRequests().anyRequest().permitAll();
//    }

}
