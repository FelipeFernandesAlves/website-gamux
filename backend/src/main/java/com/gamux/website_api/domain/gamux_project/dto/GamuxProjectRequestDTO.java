package com.gamux.website_api.domain.gamux_project.dto;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public record GamuxProjectRequestDTO(
    String name, 
    String description,
    List<String> tags, 
    List<String> genres, 
    String status, 
    String type,
    String teamLeaderUsername,
    List<String> teamMembersUsernames,
    MultipartFile logo
) {
    
}
