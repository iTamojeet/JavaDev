package com.example.unidirectional.repository;


import com.example.unidirectional.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}