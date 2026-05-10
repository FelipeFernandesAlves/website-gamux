package com.gamux.website_api.domain.user.dto;

import java.util.UUID;

import com.gamux.website_api.domain.user.User;
import com.gamux.website_api.domain.user.enums.UserRole;

public record UserResponseDTO(UUID id, String username, String name, String email, String avatar, UserRole role) {
    public UserResponseDTO(User user) {
        this(
            user.getId(),
            user.getUsername(),
            user.getName(),
            user.getEmail(),
            user.getAvatar(),
            user.getRole()
        );
    }

}
