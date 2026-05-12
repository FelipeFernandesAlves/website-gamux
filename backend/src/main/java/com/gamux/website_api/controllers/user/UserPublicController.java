package com.gamux.website_api.controllers.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gamux.website_api.domain.user.dto.UserResponseDTO;
import com.gamux.website_api.repositories.user.UserRepository;

@RestController
@RequestMapping("/public/users")
public class UserPublicController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> getAllUsers() {
        return ResponseEntity.ok(
            userRepository.findAll().stream()
                .map(UserResponseDTO::new)
                .toList()
        );
    }
}