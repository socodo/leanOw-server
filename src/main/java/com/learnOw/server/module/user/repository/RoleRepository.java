package com.learnOw.server.module.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learnOw.server.module.user.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

} 