package com.gamux.website_api.repositories.gamux_project;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gamux.website_api.domain.gamux_project.GamuxProject;

public interface GamuxProjectRepository extends JpaRepository<GamuxProject, UUID> {
    Optional<GamuxProject> findBySlug(String projectSlug);
}
