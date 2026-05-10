package com.gamux.website_api.domain.user;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.gamux.website_api.domain.user.dto.RegisterRequestDTO;
import com.gamux.website_api.domain.user.dto.UserRequestDTO;
import com.gamux.website_api.domain.user.enums.UserRole;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
public class User implements UserDetails {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    
    @NotBlank
    private String username;

    @NotBlank
    private String password;

    @Enumerated(EnumType.STRING) @NotNull
    private UserRole role;

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

    public User(RegisterRequestDTO data, String password) {
        this.username = data.username();
        this.password = password;
        this.name = data.name();
        this.email = data.email();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        switch (this.role) {
            case ADMIN:
                return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_STAFF"), new SimpleGrantedAuthority("ROLE_USER"));
            case STAFF:
                return List.of(new SimpleGrantedAuthority("ROLE_USER"), new SimpleGrantedAuthority("ROLE_STAFF"));
            default:
                return List.of(new SimpleGrantedAuthority("ROLE_USER"));
        }
    }

}
