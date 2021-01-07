package com.fedorov.springboot.dao;



import com.fedorov.springboot.model.Role;

import java.util.Set;

public interface RoleDao {
    Set<Role> getAllRoles();
    Role getRoleId(long id);
}

