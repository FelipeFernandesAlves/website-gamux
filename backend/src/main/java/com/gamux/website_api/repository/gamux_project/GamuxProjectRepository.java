package com.gamux.website_api.repository.gamux_project;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gamux.website_api.domain.gamux_project.GamuxProject;

public interface GamuxProjectRepository extends JpaRepository<GamuxProject, UUID> {
    
}
