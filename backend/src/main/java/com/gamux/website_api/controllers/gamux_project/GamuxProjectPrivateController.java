package com.gamux.website_api.controllers.gamux_project;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gamux.website_api.domain.gamux_project.dto.AddMemberRequestDTO;
import com.gamux.website_api.domain.gamux_project.dto.GamuxProjectRequestDTO;
import com.gamux.website_api.domain.gamux_project.dto.GamuxProjectResponseDTO;
import com.gamux.website_api.domain.gamux_project.dto.GamuxProjectUpdateRequestDTO;
import com.gamux.website_api.domain.gamux_project.dto.GamuxProjectUpdateResponseDTO;
import com.gamux.website_api.domain.gamux_project.dto.ProjectMemberRequestDTO;
import com.gamux.website_api.domain.gamux_project.dto.ProjectMemberResponseDTO;
import com.gamux.website_api.services.GamuxProjectService;

@RestController
@RequestMapping("/private/projects")
public class GamuxProjectPrivateController {

    @Autowired
    GamuxProjectService gamuxProjectService;

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

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteProject(@RequestParam UUID id) {
        try {
            gamuxProjectService.deleteProject(id);
            return ResponseEntity.ok("Projecto deletado com sucesso.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro ao deletar projeto: projeto não encotrado.");
        }
    }

    @PatchMapping("/update")
    public ResponseEntity<GamuxProjectUpdateResponseDTO> updateProject(@ModelAttribute GamuxProjectUpdateRequestDTO data, @RequestParam UUID id) {
        try {
            GamuxProjectUpdateResponseDTO response = gamuxProjectService.updateProject(data, id);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/member/add")
    public ResponseEntity<ProjectMemberResponseDTO> addProjectMember(@RequestBody AddMemberRequestDTO data) {
        try {
            ProjectMemberResponseDTO response = gamuxProjectService.addProjectMember(data);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.badRequest().build();
        }
    }

    @PatchMapping("/member/update")
    public ResponseEntity<ProjectMemberResponseDTO> updateProjectMember(@RequestBody AddMemberRequestDTO data) {
        try {
            ProjectMemberResponseDTO response = gamuxProjectService.updateProjectMember(data);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/member/delete")
    public ResponseEntity<String> deleteProjectMember(@RequestBody ProjectMemberRequestDTO data) {
        try {
            gamuxProjectService.deleteProjectMember(data);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.badRequest().build();
        }
    }
}
