package com.fedorov.springboot.service;

import com.fedorov.springboot.model.Role;

import java.util.Set;


public interface RoleService {


    Set<Role> getAllRoles();

    Set<Role> getRolesByName(String[] Array);

    Role getRoleId(long id);
}

