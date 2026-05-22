package com.gamux.website_api.controllers.gamux_project;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gamux.website_api.domain.gamux_project.dto.GamuxProjectPageResponseDTO;
import com.gamux.website_api.domain.gamux_project.dto.GamuxProjectResponseDTO;
import com.gamux.website_api.domain.gamux_project.dto.ProjectMemberResponseDTO;
import com.gamux.website_api.repositories.gamux_project.GamuxProjectMemberRepository;
import com.gamux.website_api.repositories.gamux_project.GamuxProjectRepository;
import com.gamux.website_api.services.GamuxProjectService;

@RestController
@RequestMapping("/public/projects")
public class GamuxProjectPublicController {
    
    @Autowired
    private GamuxProjectRepository gamuxProjectRepository;

    @Autowired
    private GamuxProjectMemberRepository gamuxProjectMemberRepository;

    @Autowired
    private GamuxProjectService gamuxProjectService;

    @GetMapping
    public ResponseEntity<Page<GamuxProjectResponseDTO>> getProjects(Pageable pageable) {
        Page<GamuxProjectResponseDTO> projects = gamuxProjectRepository.findAll(pageable)
            .map(project -> {
                List<ProjectMemberResponseDTO> teamMembers = gamuxProjectMemberRepository.findByProjectId(project.getId()).stream()
                    .map(ProjectMemberResponseDTO::new)
                    .toList();
                return new GamuxProjectResponseDTO(project, teamMembers);
            });
        return ResponseEntity.ok(projects);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GamuxProjectResponseDTO> getProject(@PathVariable("id") UUID id) {
        try {
            GamuxProjectResponseDTO response = gamuxProjectService.getById(id);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/page/{id}")
    public ResponseEntity<GamuxProjectPageResponseDTO> getProjectPageInfo(@PathVariable("id") UUID projectId) {
        try {
            GamuxProjectPageResponseDTO response = gamuxProjectService.getPageInfoByProjectId(projectId);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }
}
