package com.example.HELLO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    JdbcUserDetailsManager users;

    public boolean addUser(Users users) {

        UserDetails new_us = User.builder()
                .username(users.getUserName())
                .password("{noop}" + users.getPassword())
                .authorities(users.getRole())
                .build();

        System.out.println(new_us.getUsername() + " " + new_us.getPassword() + " "
                + new_us.getAuthorities().stream().findFirst().get());

        this.users.createUser(new_us);
        return true;
    }
}