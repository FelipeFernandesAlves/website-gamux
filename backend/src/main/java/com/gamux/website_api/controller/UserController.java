package com.gamux.website_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.gamux.website_api.domain.user.User;
import com.gamux.website_api.domain.user.dto.RegisterUserDTO;
import com.gamux.website_api.domain.user.dto.UserResponseDTO;
import com.gamux.website_api.repository.user.UserRepository;
import com.gamux.website_api.service.ImageService;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ImageService imageService;

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> getAllUsers() {
        return ResponseEntity.ok(
            userRepository.findAll().stream()
                .map(UserResponseDTO::new)
                .toList()
        );
    }

    @PostMapping(value = "/register", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<UserResponseDTO> registerUser(@RequestPart("data") RegisterUserDTO data, @RequestPart(value = "avatar", required = false) MultipartFile avatar) {
        User user = new User(data);

        try {
            if (avatar != null && !avatar.isEmpty()) {
                String imgUrl = imageService.uploadImage(avatar);
                user.setAvatar(imgUrl);
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
        
        userRepository.save(user);
        return ResponseEntity.ok(new UserResponseDTO(user));
    }
}
