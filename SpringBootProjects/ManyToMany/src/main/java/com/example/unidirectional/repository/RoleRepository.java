package com.example.unidirectional.repository;


import com.example.unidirectional.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}