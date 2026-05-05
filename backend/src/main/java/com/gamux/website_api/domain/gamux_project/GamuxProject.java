package com.gamux.website_api.domain.gamux_project;
import java.util.Date;
import java.util.UUID;

import com.gamux.website_api.domain.gamux_project.enums.ProjectStatus;
import com.gamux.website_api.domain.gamux_project.enums.ProjectType;
import com.gamux.website_api.domain.user.User;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
    private String description;
    private String logo;
    private String[] tags;
    private String[] genres;
    private ProjectStatus status;
    private ProjectType type;
    private int likes;
    
    @ManyToOne @JoinColumn(name = "team_leader")
    private User teamLeader;
    private Date createdAt;
    private Date lastUpdate;
}
