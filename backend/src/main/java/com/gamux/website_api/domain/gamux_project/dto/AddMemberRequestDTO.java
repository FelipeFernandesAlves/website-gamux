package com.gamux.website_api.domain.gamux_project.dto;

import java.util.UUID;

import com.gamux.website_api.domain.gamux_project.enums.MemberRole;

public record AddMemberRequestDTO(UUID projectId, String username, MemberRole role) {}
