package com.gamux.website_api.domain.gamux_project;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.UUID;

import com.gamux.website_api.domain.user.User;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
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
@Table(name = "gamux_project_member")
public class GamuxProjectMember {   
    @EmbeddedId
    private ProjectMemberId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("projectId")
    @JoinColumn(name = "project_id")
    private GamuxProject project;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "role")
    private String role;

    @Column(name = "joined_at", insertable = false, updatable = false)
    private OffsetDateTime joinedAt;
}

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
@Embeddable
class ProjectMemberId implements Serializable {
    @Column(name = "project_id")
    private UUID projectId;

    @Column(name = "user_id")
    private UUID userId;
}