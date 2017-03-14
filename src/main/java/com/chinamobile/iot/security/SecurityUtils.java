package com.chinamobile.iot.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Utility class for Spring Security.
 */
public final class SecurityUtils {
    private final static Logger logger = LoggerFactory.getLogger(SecurityUtils.class);

    private SecurityUtils() {
    }

    /**
     * Get the login of the current user.
     *
     * @return the login of the current user
     */
    public static User getCurrentUser() {
        User user = null;
        try {
            SecurityContext securityContext = SecurityContextHolder.getContext();
            Authentication authentication = securityContext.getAuthentication();
            if (authentication != null && authentication.getPrincipal() instanceof User) {
                user = (User) authentication.getPrincipal();
            }
        } catch (Exception e) {
            logger.error("get user info failed!", e);
        }
        return user;
    }

    /**
     * Get the login of the current user.
     *
     * @return the login of the current user
     */
    public static Integer getCurrentUserId() {
       return getCurrentUser().getUserId();
    }


}
