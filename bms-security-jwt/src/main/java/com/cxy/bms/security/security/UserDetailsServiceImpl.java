package com.cxy.bms.security.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * @author chenxy
 * @date 2020/4/28 11:25
 * @desc this is description
 */
@Component
public class UserDetailsServiceImpl implements UserDetailsService {
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        return null;
    }
}
