package com.example.projektai.repositories;

import com.example.projektai.entities.Role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {

    @Query(nativeQuery = true, value = "select * from roles where title = ?1 limit 1")
    Role getRoleByTitle(String title);
}
