package com.gamux.website_api.repositories.gamux_project;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gamux.website_api.domain.gamux_project.GamuxProjectPageInfo;

public interface GamuxProjectPageInfoRepository extends JpaRepository<GamuxProjectPageInfo, UUID> {
    Optional<GamuxProjectPageInfo> findByProjectId(UUID projectId);
}
