package com.chinamobile.iot.lightapp.mysql.config;

import com.chinamobile.iot.lightapp.mysql.service.UserService;
import com.chinamobile.iot.lightapp.mysql.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * Authenticate a user from the database.
 */
@Component("userDetailsService")
public class DomainUserDetailsService implements UserDetailsService {

    private final Logger log = LoggerFactory.getLogger(DomainUserDetailsService.class);
    @Autowired
    private UserService userService;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(final String phone) throws UsernameNotFoundException {
        log.debug("Authenticating {}", phone);
        User user = userService.findUserByPhone(phone);
        if(user == null) {
            throw new UsernameNotFoundException("User " + phone + " was not found in the " + "database");
        }
        List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
        grantedAuthorities.add(new SimpleGrantedAuthority("admin"));
        return new org.springframework.security.core.userdetails.User(phone, user.getPassword(), grantedAuthorities);
    }
}
