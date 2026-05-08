package com.gamux.website_api.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gamux.website_api.domain.gamux_project.dto.GamuxProjectRequestDTO;
import com.gamux.website_api.domain.gamux_project.dto.GamuxProjectResponseDTO;
import com.gamux.website_api.domain.gamux_project.dto.GamuxProjectUpdateRequestDTO;
import com.gamux.website_api.domain.gamux_project.dto.GamuxProjectUpdateResponseDTO;
import com.gamux.website_api.domain.gamux_project.dto.TeamMemberResponseDTO;
import com.gamux.website_api.repository.gamux_project.GamuxProjectMemberRepository;
import com.gamux.website_api.repository.gamux_project.GamuxProjectRepository;
import com.gamux.website_api.service.GamuxProjectService;

@Controller
@RequestMapping("/projects")
public class GamuxProjectController {
    
    @Autowired
    private GamuxProjectRepository gamuxProjectRepository;

    @Autowired
    private GamuxProjectMemberRepository gamuxProjectMemberRepository;

    @Autowired
    private GamuxProjectService gamuxProjectService;

    @GetMapping
    public ResponseEntity<List<GamuxProjectResponseDTO>> getProjects() {
        List<GamuxProjectResponseDTO> projects = gamuxProjectRepository.findAll().stream()
            .map(project -> {
                List<TeamMemberResponseDTO> teamMembers = gamuxProjectMemberRepository.findByProjectId(project.getId()).stream()
                    .map(TeamMemberResponseDTO::new)
                    .toList();
                return new GamuxProjectResponseDTO(project, teamMembers);
            })
            .toList();
        return ResponseEntity.ok(projects);
    }

    @GetMapping({"/{id}/{slug}", "/{id}"})
    public ResponseEntity<GamuxProjectResponseDTO> getProject(@PathVariable("id") UUID id, @PathVariable(name = "slug", required = false) String slug) {
        try {
            GamuxProjectResponseDTO response = gamuxProjectService.getById(id);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping(value = "/add", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<GamuxProjectResponseDTO> addProject(@ModelAttribute GamuxProjectRequestDTO data) {
        try {
            GamuxProjectResponseDTO response = gamuxProjectService.addProject(data);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            System.err.println(e);
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/delete")
    public ResponseEntity<String> deleteProject(@RequestParam UUID id) {
        try {
            gamuxProjectService.deleteProject(id);
            return ResponseEntity.ok("Projecto deletado com sucesso.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro ao deletar projeto: projeto não encotrado.");
        }
    }

    @PostMapping("/update")
    public ResponseEntity<GamuxProjectUpdateResponseDTO> updateProject(@ModelAttribute GamuxProjectUpdateRequestDTO data, @RequestParam UUID id) {
        try {
            GamuxProjectUpdateResponseDTO response = gamuxProjectService.updateProject(data, id);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.badRequest().build();
        }
    }
}
