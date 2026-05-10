package com.gamux.website_api.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gamux.website_api.domain.user.dto.UserResponseDTO;
import com.gamux.website_api.repositories.user.UserRepository;
import com.gamux.website_api.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

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

    @PostMapping("/delete")
    public ResponseEntity<String> deleteUser(@RequestParam UUID id) {
        try {
            userService.deleteUser(id);
            return ResponseEntity.ok("Usuário deletado com sucesso.");
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.badRequest().build();
        }
    }
}
