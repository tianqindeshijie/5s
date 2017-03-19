package com.chinamobile.iot.security;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by xuetao on 2017/2/27.
 * <p>认证失败后调用的处理类</p>
 */
@Component
public class RestAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {
    public RestAuthenticationFailureHandler() {

    }

    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        if (exception instanceof BadCredentialsException) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Incorrect password!");
        } else if (exception instanceof UsernameNotFoundException) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "User not found!");
        } else {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Authentication failed");
        }
    }
}