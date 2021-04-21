package com.arsene.authorizationserver.repository;


import com.arsene.authorizationserver.model.AuthRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<AuthRole, Long> {
    AuthRole findByRoleNameContaining(String roleName);
}