package com.fedorov.springboot.dao;

import com.fedorov.springboot.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    EntityManager entityManager;

    public List<User> getAllUsers() {
        TypedQuery<User> tQuery = (TypedQuery<User>) entityManager.createQuery("SELECT u FROM User u");
        List<User> internalList = tQuery.getResultList();
        return internalList;
    }

    public User getUser(long id) {
        return entityManager.find(User.class, id);
    }

    public void save(User user) {
        entityManager.persist(user);
    }

    public void update(User user) {
        entityManager.merge(user);
    }

    @Override
    public void delete(long id) {
        entityManager.remove(getUser(id));
    }

    @Override
    public UserDetails loadUserByUsername(String userName) {
        UserDetails userDetails = (UserDetails) entityManager.createQuery("SELECT u FROM User u WHERE u.name=:userName").
                setParameter("userName", userName).getSingleResult();
        return userDetails;
    }
}

