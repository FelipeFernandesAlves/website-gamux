package com.gamux.website_api.domain.gamux_project;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import com.gamux.website_api.domain.gamux_project.dto.GamuxProjectRequestDTO;
import com.gamux.website_api.domain.gamux_project.dto.GamuxProjectUpdateRequestDTO;
import com.gamux.website_api.domain.gamux_project.enums.ProjectStatus;
import com.gamux.website_api.domain.gamux_project.enums.ProjectType;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class GamuxProject {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank
    private String name;
    private String slug;
    private String description;
    private String logo;
    private List<String> tags;
    private List<String> genres;

    @Enumerated(EnumType.STRING)
    @JdbcTypeCode(SqlTypes.NAMED_ENUM)
    private ProjectStatus status;

    @Enumerated(EnumType.STRING)
    @JdbcTypeCode(SqlTypes.NAMED_ENUM)
    private ProjectType type;
    private int likes;
    
    private Date createdAt;
    private Date lastUpdated;

    public GamuxProject(GamuxProjectRequestDTO data) {
        this.name = data.name();
        this.description = data.description();
        this.tags = data.tags();
        this.genres = data.genres();
        this.status = ProjectStatus.valueOf(data.status());
        this.type = ProjectType.valueOf(data.type());
        this.createdAt = new Date();
        this.lastUpdated = null;
        this.likes = 0;
    }
    
    public void update(GamuxProjectUpdateRequestDTO data) {
        if (data.name() != null) setName(data.name());
        if (data.description() != null) setDescription(data.description());
        if (data.tags() != null) setTags(data.tags());
        if (data.genres() != null) setGenres(data.genres());
        if (data.status() != null) setStatus(ProjectStatus.valueOf(data.status()));
        if (data.type() != null) setType(ProjectType.valueOf(data.type()));
    }
}
