package com.gamux.website_api.domain.user.dto;

import com.gamux.website_api.domain.user.User;

public record UserResponseDTO(String username, String name, String email, String avatar) {
    public UserResponseDTO(User user) {
        this(
            user.getUsername(),
            user.getName(),
            user.getEmail(),
            user.getAvatar()
        );
    }

}
