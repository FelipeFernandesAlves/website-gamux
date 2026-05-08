package com.gamux.website_api.repository.gamux_project;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gamux.website_api.domain.gamux_project.GamuxProjectMember;

public interface GamuxProjectMemberRepository extends JpaRepository<GamuxProjectMember, UUID> {

    List<GamuxProjectMember> findByProjectId(UUID id);
    
}
