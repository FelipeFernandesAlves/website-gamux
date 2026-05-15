package com.gamux.website_api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.gamux.website_api.domain.user.User;
import com.gamux.website_api.domain.user.dto.RegisterRequestDTO;
import com.gamux.website_api.domain.user.dto.UpdateUserRequestDTO;
import com.gamux.website_api.domain.user.dto.UserResponseDTO;
import com.gamux.website_api.domain.user.enums.UserRole;
import com.gamux.website_api.repositories.user.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class UserService {
    
    @Autowired
    private ImageService imageService;
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SlugifyService slugifyService;

    @Transactional(rollbackOn = Exception.class)
    public UserResponseDTO registerUser(RegisterRequestDTO data, String role) throws Exception {
        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        User user = new User(data, encryptedPassword);
        user.setUsername(slugifyService.toSlug(user.getUsername()));
        user.setRole(UserRole.valueOf(role));

        MultipartFile avatar = data.avatar();
        try {
            if (avatar != null && !avatar.isEmpty()) {
                String imgUrl = imageService.uploadImage(avatar);
                user.setAvatar(imgUrl);
            }
        } catch (Exception e) {
            throw new Exception(e);
        }
        
        return new UserResponseDTO(userRepository.save(user));
    }

    public UserResponseDTO updateUser(UpdateUserRequestDTO data, String username) throws Exception {
        User user = userRepository.findByUsername(username).orElse(null);
        if (user == null)
            throw new Exception("[UPDATE USER] - Usuário não encontrado.");

        user.update(data);
        if (!data.removeAvatar()) {
            if (data.avatar() != null) {
                String avatarUrl = imageService.uploadImage(data.avatar());
                imageService.deleteImage(user.getAvatar());
                user.setAvatar(avatarUrl);
            }
        } else {
            imageService.deleteImage(user.getAvatar());
            user.setAvatar(null);
        } 

        return new UserResponseDTO(userRepository.save(user));
    }

    public void deleteUser(String username) throws Exception {
        User user = userRepository.findByUsername(username).orElse(null);
        if (user == null) throw new Exception("[DELETE USER] - Usuário não encotrado");

        imageService.deleteImage(user.getAvatar());
        userRepository.delete(user);
    }
}
