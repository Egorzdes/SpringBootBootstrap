package com.fedorov.springboot.dao;

import com.fedorov.springboot.model.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();

    User getUser(long id);

    void save(User user);

    void update(User user);

    void delete(long id);

    UserDetails loadUserByUsername(String userName);
}

