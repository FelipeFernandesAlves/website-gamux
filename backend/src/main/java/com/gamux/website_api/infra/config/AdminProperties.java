package com.gamux.website_api.infra.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.Setter;

@Configuration
@ConfigurationProperties(prefix = "api.init.admin")
@Getter
@Setter
public class AdminProperties {
    private String username;
    private String password;
    private String email;
}
