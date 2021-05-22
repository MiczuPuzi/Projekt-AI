package com.example.projektai.repositories;

import com.example.projektai.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(nativeQuery = true, value = "SELECT * from users where username = ?1 limit 1")
    User findByUsername(String username);

}
