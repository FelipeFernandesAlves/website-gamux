package com.gamux.website_api.domain.user.dto;

import org.springframework.web.multipart.MultipartFile;

public record UpdateUserRequestDTO(
    String name,
    String username,
    String email,
    MultipartFile avatar,
    boolean removeAvatar
) {}
