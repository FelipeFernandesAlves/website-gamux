package com.gamux.website_api.domain.gamux_project;

import java.util.Map;
import java.util.UUID;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import com.gamux.website_api.domain.gamux_project.dto.GamuxProjectPageUpdateRequestDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@Entity
public class GamuxProjectPageInfo {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gamux_project_id")
    private GamuxProject project;

    private String description;
    private String banner;

    @JdbcTypeCode(SqlTypes.JSON)
    private Map<String, String> externalLinks;

    private String bgColor;
    private String bg2Color;
    private String textColor;
    private String linkColor;
    private String headingColor;

    public GamuxProjectPageInfo() {
        this.bgColor = "#000";
        this.bg2Color = "#000";
        this.textColor = "#f8f0fb";
        this.linkColor = "#FBD87F";
        this.headingColor = "#A411CD";
    }

    public void update(GamuxProjectPageUpdateRequestDTO data) {
        if (data.description() != null) this.description = data.description();
        if (data.externalLinks() != null) this.externalLinks = data.externalLinks();
        if (data.bgColor() != null) this.bgColor = data.bgColor();
        if (data.bg2Color() != null) this.bg2Color = data.bg2Color();
        if (data.textColor() != null) this.textColor = data.textColor();
        if (data.linkColor() != null) this.linkColor = data.linkColor();
        if (data.headingColor() != null) this.headingColor = data.headingColor();
    }
}