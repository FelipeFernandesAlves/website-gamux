package com.gamux.website_api.domain.user.dto;

import org.springframework.web.multipart.MultipartFile;

public record RegisterRequestDTO(String username, String password, String name, String email, MultipartFile avatar) {
    
}
