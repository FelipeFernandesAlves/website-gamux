package com.gamux.website_api.domain.gamux_project.dto;

import java.util.List;

import com.gamux.website_api.domain.gamux_project.GamuxProject;

public record GamuxProjectUpdateResponseDTO(
    String name,
    String description,
    List<String> tags,
    List<String> genres,
    String status,
    String type    
) {
    public GamuxProjectUpdateResponseDTO(GamuxProject project) {
        this(
            project.getName(),
            project.getDescription(),
            project.getTags(),
            project.getGenres(),
            project.getStatus().toString(),
            project.getType().toString()
        );
    }
}
