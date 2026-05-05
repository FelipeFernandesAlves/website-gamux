package com.gamux.website_api.repository.user;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gamux.website_api.domain.user.User;

public interface UserRepository extends JpaRepository<User, UUID> {}
