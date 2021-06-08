package com.arsene.authorizationserver.repository;

import com.arsene.authorizationserver.model.AuthUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<AuthUser, Long> {
    Optional<AuthUser> findByUserName(String username);
    Optional<AuthUser> findByUserNameOrEmail(String username, String email);
}