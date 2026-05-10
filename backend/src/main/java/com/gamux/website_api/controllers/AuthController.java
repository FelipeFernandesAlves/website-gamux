package com.gamux.website_api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gamux.website_api.domain.user.User;
import com.gamux.website_api.domain.user.dto.LoginRequestDTO;
import com.gamux.website_api.domain.user.dto.LoginResponseDTO;
import com.gamux.website_api.domain.user.dto.RegisterRequestDTO;
import com.gamux.website_api.domain.user.dto.UserResponseDTO;
import com.gamux.website_api.infra.security.TokenService;
import com.gamux.website_api.repositories.user.UserRepository;
import com.gamux.website_api.services.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired private AuthenticationManager authManager;
    @Autowired private UserRepository userRepository;
    @Autowired private UserService userService;
    @Autowired private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody @Valid LoginRequestDTO data) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.username(), data.password());
        Authentication auth = this.authManager.authenticate(usernamePassword);
        String token = tokenService.generateToken((User) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    @PostMapping(value = "/register", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<UserResponseDTO> register(@ModelAttribute @Valid RegisterRequestDTO data) {    
        try {
            if (userRepository.findByUsername(data.username()) != null)
                return ResponseEntity.badRequest().build();
            return ResponseEntity.ok(userService.registerUser(data, "USER"));
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.badRequest().build();
        }
    }
}

