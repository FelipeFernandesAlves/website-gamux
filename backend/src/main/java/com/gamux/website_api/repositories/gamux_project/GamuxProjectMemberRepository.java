package com.gamux.website_api.repositories.gamux_project;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gamux.website_api.domain.gamux_project.GamuxProjectMember;

public interface GamuxProjectMemberRepository extends JpaRepository<GamuxProjectMember, UUID> {
    List<GamuxProjectMember> findByProjectId(UUID id);

    @Query("SELECT m FROM GamuxProjectMember m WHERE m.project.id = :projectId AND m.user.username = :username")
    Optional<GamuxProjectMember> findByProjectIdAndUserUsername(UUID projectId, String username);   
}
