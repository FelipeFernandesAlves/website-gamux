package com.gamux.website_api.domain.gamux_project.dto;

import java.util.Map;

import com.gamux.website_api.domain.gamux_project.GamuxProjectPageInfo;

public record GamuxProjectPageResponseDTO(
    String description,
    String banner,
    Map<String, String> externalLinks,
    String[] screenshots,
    String bgColor,
    String bg2color,
    String textColor,
    String linkColor,
    String headingColor
) {
    public GamuxProjectPageResponseDTO(GamuxProjectPageInfo data) {
        this(
            data.getDescription(),
            data.getBanner(),
            data.getExternalLinks(),
            new String[] {},
            data.getBgColor(),
            data.getBgColor(),
            data.getTextColor(),
            data.getLinkColor(),
            data.getHeadingColor()
        );
    }
}
