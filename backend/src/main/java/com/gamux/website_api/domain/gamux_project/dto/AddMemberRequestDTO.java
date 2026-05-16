package com.gamux.website_api.domain.gamux_project.dto;
import com.gamux.website_api.domain.gamux_project.enums.MemberRole;

public record AddMemberRequestDTO(String username, MemberRole role) {}
