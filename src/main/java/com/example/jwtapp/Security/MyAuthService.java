package com.example.jwtapp.Security;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class MyAuthService implements UserDetailsService {

    @Lazy
    @Autowired
    PasswordEncoder encoder;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        List<User> userlist = new ArrayList<>(Arrays.asList(
            new User("user",encoder.encode("USER"),new ArrayList<>()),
            new User("admin",encoder.encode("ADMIN"),new ArrayList<>())
        ));

        for (User user : userlist) {
            if(user.getUsername().equals(username)){
                return user;
            }
            
        }
        return null;
    }

}
