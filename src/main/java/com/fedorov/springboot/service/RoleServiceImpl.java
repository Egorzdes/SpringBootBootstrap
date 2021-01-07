package com.fedorov.springboot.service;

import com.fedorov.springboot.model.Role;
import com.fedorov.springboot.dao.RoleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    private RoleDao roleDAO;


    public RoleServiceImpl() {

    }

    @Autowired
    public RoleServiceImpl(RoleDao roleDAO) {
        this.roleDAO = roleDAO;
    }

    public Set<Role> getAllRoles() {
        return this.roleDAO.getAllRoles();
    }

    public Set<Role> getRolesByName(String[] Array) {
        Set<Role> newSetOfRoles = new HashSet<>();
        Set<Role> setOfAllRole = this.getAllRoles();

        for (String roleName : Array) {
            for (Role role : setOfAllRole) {
                if (role.getRole().equals(roleName)) {
                    newSetOfRoles.add(role);
                }
            }
        }
        return newSetOfRoles;
    }

    @Override
    public Role getRoleId(long id){
        return roleDAO.getRoleId(id);
    }
}

