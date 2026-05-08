package com.gamux.website_api.domain.gamux_project.dto;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.gamux.website_api.domain.gamux_project.GamuxProject;
import com.gamux.website_api.domain.gamux_project.enums.ProjectStatus;
import com.gamux.website_api.domain.gamux_project.enums.ProjectType;

public record GamuxProjectResponseDTO(
    UUID id,
    String name,
    String slug,
    String desc,
    String logo,
    List<String> tags,
    List<String> genres,
    ProjectStatus status,
    ProjectType type,
    int likes,
    List<TeamMemberResponseDTO> teamMembers,
    Date createdAt,
    Date lastUpdated
) {

    public GamuxProjectResponseDTO(GamuxProject project, List<TeamMemberResponseDTO> teamMembers) {
        this(
            project.getId(),
            project.getName(),
            project.getSlug(),
            project.getDescription(),
            project.getLogo(),
            project.getTags(),
            project.getGenres(),
            project.getStatus(),
            project.getType(),
            project.getLikes(),
            teamMembers,
            project.getCreatedAt(),
            project.getLastUpdated()
        );
    }
}