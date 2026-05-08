package com.gamux.website_api.domain.user;

import java.util.UUID;

import com.gamux.website_api.domain.user.dto.UserRequestDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    
    @NotBlank
    private String username;

    @NotBlank
    private String name;

    @NotBlank @Email
    private String email;

    private String avatar;

    public User(UserRequestDTO data) {
        this.username = data.username();
        this.name = data.name();
        this.email = data.email();
    }
}
