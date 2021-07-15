package com.example.udemy_project1.repository;

import com.example.udemy_project1.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users,Long> {

    Users findByUsername(String username);
}
