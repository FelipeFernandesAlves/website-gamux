package com.gamux.website_api.domain.user.dto;

import com.gamux.website_api.domain.user.User;
import com.gamux.website_api.domain.user.enums.UserRole;

public record UserResponseDTO(String username, String name, String email, String avatar, UserRole role) {
    public UserResponseDTO(User user) {
        this(
            user.getUsername(),
            user.getName(),
            user.getEmail(),
            user.getAvatar(),
            user.getRole()
        );
    }
}
