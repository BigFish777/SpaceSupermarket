package com.hxp.ssmkert.config;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 一颗小土豆
 * \* Date: 2020/5/27
 * \* Time: 11:59
 * \
 */
@Service
public class MyUserDetailsService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        /**
         * 模拟用户信息
         */
        UserDetails userDetails = User.withUsername("admin").password("$2a$10$Hj7W2Y1ruGOkr4kNvot4z.j8vDqMHas0wM6FcOp5hBklOlPwQCBQG").authorities("p1", "p2").build();
        return userDetails;
    }
}
