package com.fedorov.springboot.service;

import com.fedorov.springboot.dao.UserDaoImpl;
import com.fedorov.springboot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private UserDaoImpl userDAO;

    public UserServiceImpl(){}

    @Autowired
    public UserServiceImpl(UserDaoImpl userDAO) {
        this.userDAO = userDAO;
    }

    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    public User getUser(long id) {
        return userDAO.getUser(id);
    }

    public void save(User user) {
        userDAO.save(user);
    }

    public void update(User updatedUser) {
        userDAO.update(updatedUser);
    }

    public void delete(long id) {
        userDAO.delete(id);
    }


    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        return userDAO.loadUserByUsername(userName);
    }
}

