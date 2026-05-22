package com.gamux.website_api.services;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gamux.website_api.domain.gamux_project.GamuxProject;
import com.gamux.website_api.domain.gamux_project.GamuxProjectMember;
import com.gamux.website_api.domain.gamux_project.GamuxProjectPageInfo;
import com.gamux.website_api.domain.gamux_project.dto.AddMemberRequestDTO;
import com.gamux.website_api.domain.gamux_project.dto.GamuxProjectPageResponseDTO;
import com.gamux.website_api.domain.gamux_project.dto.GamuxProjectPageUpdateRequestDTO;
import com.gamux.website_api.domain.gamux_project.dto.GamuxProjectRequestDTO;
import com.gamux.website_api.domain.gamux_project.dto.GamuxProjectResponseDTO;
import com.gamux.website_api.domain.gamux_project.dto.GamuxProjectUpdateRequestDTO;
import com.gamux.website_api.domain.gamux_project.dto.GamuxProjectUpdateResponseDTO;
import com.gamux.website_api.domain.gamux_project.dto.ProjectMemberRequestDTO;
import com.gamux.website_api.domain.gamux_project.dto.ProjectMemberResponseDTO;
import com.gamux.website_api.domain.user.User;
import com.gamux.website_api.repositories.gamux_project.GamuxProjectMemberRepository;
import com.gamux.website_api.repositories.gamux_project.GamuxProjectPageInfoRepository;
import com.gamux.website_api.repositories.gamux_project.GamuxProjectRepository;
import com.gamux.website_api.repositories.user.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class GamuxProjectService {

    @Autowired private GamuxProjectRepository gamuxProjectRepository;
    @Autowired private GamuxProjectMemberRepository gamuxProjectMemberRepository;
    @Autowired private GamuxProjectPageInfoRepository pageInfoRepository;
    @Autowired private UserRepository userRepository;
    @Autowired private ImageService imageService;
    @Autowired private SlugifyService slugifyService;

    @Transactional(rollbackOn = Exception.class)
    public GamuxProjectResponseDTO addProject(GamuxProjectRequestDTO data) throws Exception {
        GamuxProject project = new GamuxProject(data);
        project.setSlug(slugifyService.toSlug(data.name()));
        GamuxProject savedProject = gamuxProjectRepository.saveAndFlush(project);

        String logoUrl = imageService.uploadImage(data.logo());
        savedProject.setLogo(logoUrl);
        gamuxProjectRepository.save(savedProject);

        GamuxProjectPageInfo pageInfo = new GamuxProjectPageInfo();
        pageInfo.setProject(savedProject);
        pageInfoRepository.save(pageInfo);

        User teamLeader = userRepository.findByUsername(data.teamLeaderUsername()).orElse(null);
        if (teamLeader == null)
            throw new Exception("team leader doesn't exists.");

        List<GamuxProjectMember> members = new ArrayList<GamuxProjectMember>();
        members.add(new GamuxProjectMember(teamLeader, savedProject, "LEADER"));

        if (data.teamMembersUsernames() != null) {
            members.addAll(data.teamMembersUsernames().stream()
                .map((String username) -> {
                    User member = userRepository.findByUsername(username).orElse(null);
                    if (member != null)
                        return new GamuxProjectMember(member, savedProject, "MEMBER");
                    
                    return null;
                })
                .filter(member -> member != null)
                .toList()
            );
        }

        List<GamuxProjectMember> savedMembers = gamuxProjectMemberRepository.saveAllAndFlush(members);
        return new GamuxProjectResponseDTO(savedProject, savedMembers.stream().map(ProjectMemberResponseDTO::new).toList());
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
        if (data.name() != null)
            project.setSlug(slugifyService.toSlug(project.getName()));
        
        return new GamuxProjectUpdateResponseDTO(project);
    }

    @Transactional(rollbackOn = Exception.class)
    public GamuxProjectResponseDTO getById(UUID id) throws Exception {
        GamuxProject project = gamuxProjectRepository.findById(id).orElse(null);
        List<ProjectMemberResponseDTO> members = gamuxProjectMemberRepository.findByProjectId(id).stream()
            .map(ProjectMemberResponseDTO::new)
            .toList();
        
        if (project == null) {
            throw new Exception("Projeto não encontrado.");
        }

        return new GamuxProjectResponseDTO(project, members);
    }

    public ProjectMemberResponseDTO addProjectMember(AddMemberRequestDTO data, UUID projectId) throws Exception {
        GamuxProject project = gamuxProjectRepository.findById(projectId).orElse(null);
        User user = userRepository.findByUsername(data.username()).orElse(null);

        if (project == null || user == null)
            throw new Exception("[ERRO] addMember: Falha ao encontrar projeto ou usuário");

        boolean alreadyInProject = gamuxProjectMemberRepository.findByUserId(user.getId()).orElse(null) != null;
        if (alreadyInProject)
            throw new Exception("[ERRO] addMember: Usuário já é um membro no projeto " + project.getName());

        GamuxProjectMember newMember = new GamuxProjectMember(user, project, data.role().toString());
        return new ProjectMemberResponseDTO(gamuxProjectMemberRepository.save(newMember));
    }

    public ProjectMemberResponseDTO updateProjectMember(AddMemberRequestDTO data, UUID projectId) throws Exception {
        GamuxProjectMember member = gamuxProjectMemberRepository.findByProjectIdAndUserUsername(projectId, data.username()).orElse(null);
        if (member == null) throw new Exception("[ERRO] updateMember: Falha ao encontrar membro.");

        member.setRole(data.role().toString());
        gamuxProjectMemberRepository.save(member);
        return new ProjectMemberResponseDTO(member);
    }

    public void deleteProjectMember(ProjectMemberRequestDTO data, UUID projectId) {
        GamuxProjectMember member = gamuxProjectMemberRepository.findByProjectIdAndUserUsername(projectId, data.username()).orElse(null);
        gamuxProjectMemberRepository.delete(member);
    }

    public GamuxProjectPageResponseDTO getPageInfoByProjectId(UUID projectId) throws Exception {
        GamuxProjectPageInfo pageInfo = pageInfoRepository.findByProjectId(projectId).orElse(null);
        if (pageInfo == null)
            throw new Exception("[ERRO] getPageInfoByProjectId: projeto não encontrado.");
        return new GamuxProjectPageResponseDTO(pageInfo);
    }

    public GamuxProjectPageResponseDTO udpdateProjectPage(GamuxProjectPageUpdateRequestDTO data, UUID id) throws Exception {
        GamuxProjectPageInfo pageInfo = pageInfoRepository.findByProjectId(id).orElse(null);
        if (pageInfo == null)
            throw new Exception("[ERRO] updateProjectPage: projeto não encontrado.");

        if (!data.removeBanner()) {
            if (data.banner() != null) {
                String newBanner = imageService.uploadImage(data.banner());
                imageService.deleteImage(pageInfo.getBanner());
                pageInfo.setBanner(newBanner);
            }
        } else {
            imageService.deleteImage(pageInfo.getBanner());
            pageInfo.setBanner(null);
        }

        pageInfo.update(data);
        pageInfoRepository.save(pageInfo);
        return new GamuxProjectPageResponseDTO(pageInfo);
    }
}
