package com.gamux.website_api.repositories.user;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;

import com.gamux.website_api.domain.user.User;

public interface UserRepository extends JpaRepository<User, UUID> {
    public User findByUsername(String username);

    @Query("SELECT u FROM User u WHERE u.username = ?1")
    public UserDetails findByLogin(String username);
}
