package com.gamux.website_api.controllers.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gamux.website_api.domain.user.User;
import com.gamux.website_api.domain.user.dto.UserResponseDTO;
import com.gamux.website_api.repositories.user.UserRepository;

@RestController
@RequestMapping("/public/users")
public class UserPublicController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public ResponseEntity<Page<UserResponseDTO>> getAllUsers(Pageable pageable) {
        return ResponseEntity.ok(
            userRepository.findAll(pageable)
                .map(UserResponseDTO::new)
        );
    }

    @GetMapping ResponseEntity<UserResponseDTO> getUser(@RequestHeader String username) {
        User user = userRepository.findByUsername(username).orElse(null);
        if (user == null)
            return ResponseEntity.badRequest().build();

        return ResponseEntity.ok(new UserResponseDTO(user));
    }
}