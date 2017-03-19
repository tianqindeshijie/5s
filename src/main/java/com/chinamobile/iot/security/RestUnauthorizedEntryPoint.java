package com.chinamobile.iot.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author sunxuetao  2017.1.5
 *<p>没有认证调用的处理类</p>
 * Returns a 401 error code (Unauthorized) to the client.
 */
@Component
public class RestUnauthorizedEntryPoint implements AuthenticationEntryPoint {

    private final Logger log = LoggerFactory.getLogger(RestUnauthorizedEntryPoint.class);

    /**
     * Always returns a 401 error code to the client.
     */
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException arg2)
        throws IOException,
            ServletException {
        log.debug("Pre-authenticated entry point called. Rejecting access");
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Access Denied");
    }
}
