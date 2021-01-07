package com.fedorov.springboot.service;

import com.fedorov.springboot.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public interface UserService extends UserDetailsService {

    List<User> getAllUsers();

    User getUser(long id);

    void save(User user);

    void update(User updatedUser);

    void delete(long id);

    @Override
    UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException;
}

