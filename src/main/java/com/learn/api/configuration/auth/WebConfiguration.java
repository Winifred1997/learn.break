
package com.learn.api.configuration.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.Http403ForbiddenEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.filter.GenericFilterBean;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebConfiguration extends WebSecurityConfigurerAdapter {

    @Value("${login.hqq.basicAuthName}")
    String authUserName;

    @Value("${login.hqq.basicAuthPass}")
    String authPassword;

    @Autowired
    public void configureAuthentication(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder
            .inMemoryAuthentication().withUser(authUserName).password(authPassword).roles("BASIC");
    }

    /**
     * http.authorizeRequests().antMatchers("/admin/**").hasRole("ADMIN")
     * .antMatchers("/**").hasRole("USER").and().formLogin();
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers(HttpMethod.OPTIONS).permitAll()
            .antMatchers("/learn/swagger**").permitAll()
//            .antMatchers("/**").authenticated()
            .and()
            .httpBasic().and()
            .csrf().disable()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
            .exceptionHandling()
            .authenticationEntryPoint(new Http403ForbiddenEntryPoint());
    }

}
