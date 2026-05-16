package com.gamux.website_api.infra.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.gamux.website_api.domain.user.User;
import com.gamux.website_api.domain.user.dto.RegisterRequestDTO;
import com.gamux.website_api.domain.user.enums.UserRole;
import com.gamux.website_api.repositories.user.UserRepository;

@Configuration
public class DatabaseInitializer {
    @Bean
    CommandLineRunner initDatabase(UserRepository userRepository, PasswordEncoder passwordEncoder, AdminProperties adminProperties) {
        return args -> {
            User admin = userRepository.findByRole(UserRole.ADMIN).orElse(null);
            if (admin != null) return;

            RegisterRequestDTO adminData = new RegisterRequestDTO(
                adminProperties.getUsername(),
                adminProperties.getPassword(),
                adminProperties.getUsername(),
                adminProperties.getEmail(),
                null
            );

            User newAdmin = new User(adminData, passwordEncoder.encode(adminProperties.getPassword()));
            newAdmin.setRole(UserRole.ADMIN);
            userRepository.save(newAdmin);
            System.out.println("Um Admin default foi criado.");
        };
    }
}
