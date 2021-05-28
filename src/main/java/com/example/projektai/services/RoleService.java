package com.example.projektai.services;

import com.example.projektai.entities.Role;
import com.example.projektai.entities.RoleName;
import com.example.projektai.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public Role findById(Long id) {
        Optional<Role> optional = roleRepository.findById(id);
        return optional.orElse(null);
    }
    public Set<Role> findAll(){
        return new HashSet<>(roleRepository.findAll());
    }

    public void save(Role role) {
        roleRepository.save(role);
    }

    public Role getRoleByName(RoleName name) {
        return roleRepository.findRoleByName(name);
    }

}
