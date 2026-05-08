package com.gamux.website_api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gamux.website_api.domain.gamux_project.GamuxProject;
import com.gamux.website_api.domain.gamux_project.GamuxProjectMember;
import com.gamux.website_api.domain.gamux_project.dto.GamuxProjectRequestDTO;
import com.gamux.website_api.domain.gamux_project.dto.GamuxProjectResponseDTO;
import com.gamux.website_api.domain.gamux_project.dto.GamuxProjectUpdateRequestDTO;
import com.gamux.website_api.domain.gamux_project.dto.GamuxProjectUpdateResponseDTO;
import com.gamux.website_api.domain.gamux_project.dto.TeamMemberResponseDTO;
import com.gamux.website_api.domain.user.User;
import com.gamux.website_api.repository.gamux_project.GamuxProjectMemberRepository;
import com.gamux.website_api.repository.gamux_project.GamuxProjectRepository;
import com.gamux.website_api.repository.user.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class GamuxProjectService {

    @Autowired
    private GamuxProjectRepository gamuxProjectRepository;
    
    @Autowired
    private GamuxProjectMemberRepository gamuxProjectMemberRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ImageService imageService;

    @Autowired
    private SlugifyService slugifyService;

    @Transactional(rollbackOn = Exception.class)
    public GamuxProjectResponseDTO addProject(GamuxProjectRequestDTO data) throws Exception {
        GamuxProject project = new GamuxProject(data);
        project.setSlug(slugifyService.toSlug(data.name()));
        GamuxProject savedProject = gamuxProjectRepository.saveAndFlush(project);

        String logoUrl = imageService.uploadImage(data.logo());
        savedProject.setLogo(logoUrl);
        gamuxProjectRepository.save(savedProject);

        User teamLeader = userRepository.findByUsername(data.teamLeaderUsername());
        List<GamuxProjectMember> members = new ArrayList<GamuxProjectMember>();
        members.add(new GamuxProjectMember(teamLeader, savedProject, "LEADER"));
        members.addAll(data.teamMembersUsernames().stream()
            .map((String username) -> {
                User member = userRepository.findByUsername(username);
                return new GamuxProjectMember(member, savedProject, "MEMBER");
            })
            .toList()
        );

        List<GamuxProjectMember> savedMembers = gamuxProjectMemberRepository.saveAllAndFlush(members);
        return new GamuxProjectResponseDTO(savedProject, savedMembers.stream().map(TeamMemberResponseDTO::new).toList());
    }

    public void deleteProject(UUID projectId) throws Exception {
        GamuxProject project = gamuxProjectRepository.findById(projectId).orElse(null);
        if (project == null) {
            throw new Exception();
        }

        imageService.deleteImage(project.getLogo());
        gamuxProjectRepository.delete(project);
    }

    @Transactional
    public GamuxProjectUpdateResponseDTO updateProject(GamuxProjectUpdateRequestDTO data, UUID id) throws Exception {
        GamuxProject project = gamuxProjectRepository.findById(id).orElse(null);
        if (project == null) {
            throw new Exception("Projeto não encontrado.");
        }

        if (!data.removeLogo()) {
            if (data.logo() != null) {
                String logoUrl = imageService.uploadImage(data.logo());
                imageService.deleteImage(project.getLogo());
                project.setLogo(logoUrl);
            }
        } else {
            imageService.deleteImage(project.getLogo());
            project.setLogo(null);
        }

        project.update(data);
        return new GamuxProjectUpdateResponseDTO(project);
    }

    @Transactional(rollbackOn = Exception.class)
    public GamuxProjectResponseDTO getById(UUID id) throws Exception {
        GamuxProject project = gamuxProjectRepository.findById(id).orElse(null);
        List<TeamMemberResponseDTO> members = gamuxProjectMemberRepository.findByProjectId(id).stream()
            .map(TeamMemberResponseDTO::new)
            .toList();
        
        if (project == null) {
            throw new Exception("Projeto não encontrado.");
        }

        return new GamuxProjectResponseDTO(project, members);
    }
}
