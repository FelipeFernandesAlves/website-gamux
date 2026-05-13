package com.gamux.website_api.domain.gamux_project.dto;

import com.gamux.website_api.domain.gamux_project.GamuxProjectMember;

public record ProjectMemberResponseDTO(String username, String name, String role) {
    public ProjectMemberResponseDTO(GamuxProjectMember member) {
        this(member.getUser().getUsername(), member.getUser().getName(), member.getRole());
    }
}
