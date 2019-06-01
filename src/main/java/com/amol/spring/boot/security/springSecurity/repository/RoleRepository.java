package com.amol.spring.boot.security.springSecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amol.spring.boot.security.springSecurity.model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{

}
