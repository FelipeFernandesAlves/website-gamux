package com.gamux.website_api.domain.gamux_project.dto;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

public record GamuxProjectPageUpdateRequestDTO(
    String description,
    MultipartFile banner,
    boolean removeBanner,
    Map<String, String> externalLinks,
    String bgColor,
    String bg2Color,
    String textColor,
    String linkColor,
    String headingColor
) {}
