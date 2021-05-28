package com.example.projektai.repositories;

import com.example.projektai.entities.Role;

import com.example.projektai.entities.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {

    Role findRoleByName(RoleName name);
}
