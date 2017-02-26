package com.chinamobile.iot.lightapp.mysql.config;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.List;

/**
 * Utility class for Spring Security.
 */
public final class SecurityUtils {

    private SecurityUtils() {
    }

    /**
     * Get the login of the current user.
     *
     * @return the login of the current user
     */
    public static String getCurrentUser() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();
        if (authentication != null) {
            authentication.getPrincipal().toString();
        }
        return "usert";
    }
    /**
     * Get the login of the current user.
     *
     * @return the login of the current user
     */
    public static Integer getCurrentUserId() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();
        if (authentication != null) {
            authentication.getPrincipal();
        }
        // TODO: 2017/2/26
        return 1234556;
    }


    public static Integer getCurrentUserRole() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();
        Integer roleId = null;
        if (authentication != null) {
            List<SimpleGrantedAuthority> authorityList = (List) authentication.getAuthorities();
            roleId = Integer.parseInt(authorityList.get(0).getAuthority());
        }
        return roleId;
    }
}
