package com.gamux.website_api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.gamux.website_api.domain.user.User;
import com.gamux.website_api.domain.user.dto.UserRequestDTO;
import com.gamux.website_api.domain.user.dto.UserResponseDTO;
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
    public UserResponseDTO registerUser(UserRequestDTO data) throws Exception {
        User user = new User(data);
        user.setUsername(slugifyService.toSlug(user.getUsername()));

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

}
