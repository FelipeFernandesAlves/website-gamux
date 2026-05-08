package com.gamux.website_api.domain.user.dto;

import org.springframework.web.multipart.MultipartFile;

public record UserRequestDTO(String username, String name, String email, MultipartFile avatar) {

}
