package com.fedorov.springboot.dao;

import com.fedorov.springboot.model.Role;
import org.springframework.stereotype.Repository;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.HashSet;
import java.util.Set;

@Repository
public class RoleDaoImpl implements RoleDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Set<Role> getAllRoles() {
        TypedQuery<Role> tQuery = (TypedQuery<Role>) entityManager.createQuery("SELECT r FROM Role r");
        Set<Role> internalRoleSet = new HashSet<>(tQuery.getResultList());
        return internalRoleSet;
    }

    @Override
    public Role getRoleId(long id) {
        return entityManager.find(Role.class, id);
    }
}


