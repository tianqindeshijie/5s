/*
 * Copyright 2014-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.chinamobile.iot.lightapp.mysql.config;

import com.chinamobile.iot.security.JsonAuthenticationSuccessHandler;
import com.chinamobile.iot.security.RestAuthenticationFailureHandler;
import com.chinamobile.iot.security.RestAuthenticationSuccessHandler;
import com.chinamobile.iot.security.RestUnauthorizedEntryPoint;
import io.github.jhipster.security.AjaxAuthenticationFailureHandler;
import io.github.jhipster.security.AjaxLogoutSuccessHandler;
import io.github.jhipster.security.Http401UnauthorizedEntryPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.SecurityConfigurer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.util.Collection;
import java.util.List;

/**
 * @author jitendra on 3/3/16.
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private RestAuthenticationSuccessHandler restAuthenticationSuccessHandler;
    @Autowired
    private RestAuthenticationFailureHandler restAuthenticationFailureHandler;
    @Autowired
    private RestUnauthorizedEntryPoint restUnauthorizedEntryPoint;

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers(HttpMethod.OPTIONS, "*")
                .antMatchers("/swagger-ui.html")
                .antMatchers("/webjars/springfox-swagger-ui/**")
                .antMatchers("/swagger-resources/**")
                .antMatchers("/v2/api-docs/**")
                .antMatchers("/management/**");
    }

    // @formatter:off
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .exceptionHandling()
                .authenticationEntryPoint(restUnauthorizedEntryPoint)
                .and()
                .sessionManagement().maximumSessions(2).and()
                .and()
                .authorizeRequests()
                .antMatchers("/management/**").permitAll()
                .antMatchers("/swagger-resources/configuration/ui").permitAll()
                .antMatchers("/webjars/springfox-swagger-ui/*").permitAll()
                .antMatchers("/register").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginProcessingUrl("/login")
                .successHandler(restAuthenticationSuccessHandler)
                .failureHandler(restAuthenticationFailureHandler)
                .usernameParameter("phone")
                .passwordParameter("password")
                .permitAll()
                .and()
                .logout().permitAll();
       /* http.addFilterAt(usernamePasswordAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);*/
    }

/*    @Bean
    public UsernamePasswordAuthenticationFilter usernamePasswordAuthenticationFilter1() {
        UsernamePasswordAuthenticationFilter usernamePasswordAuthenticationFilter = new UsernamePasswordAuthenticationFilter();
        usernamePasswordAuthenticationFilter.setPostOnly(false);
        return usernamePasswordAuthenticationFilter;
    }*/
    // @formatter:on

    // @formatter:off
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
        /*auth
                .inMemoryAuthentication()
                .withUser("user").password("password").roles("USER")
                .and()
                .withUser("user1").password("password").roles("USER1");*/
    }
    // @formatter:on

    @Bean
    public AjaxLogoutSuccessHandler ajaxLogoutSuccessHandler() {
        return new AjaxLogoutSuccessHandler();
    }

}
