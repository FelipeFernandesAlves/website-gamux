package com.gamux.website_api.domain.gamux_project.dto;

import java.util.UUID;

public record ProjectMemberRequestDTO(UUID projectId, String username) {}