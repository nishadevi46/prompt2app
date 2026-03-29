package com.nisha.projects.prompt2app.service.impl;

import com.nisha.projects.prompt2app.dto.project.ProjectRequest;
import com.nisha.projects.prompt2app.dto.project.ProjectResponse;
import com.nisha.projects.prompt2app.dto.project.ProjectSummaryResponse;
import com.nisha.projects.prompt2app.entity.Project;
import com.nisha.projects.prompt2app.entity.ProjectMember;
import com.nisha.projects.prompt2app.entity.ProjectMemberId;
import com.nisha.projects.prompt2app.entity.User;
import com.nisha.projects.prompt2app.enums.ProjectRole;
import com.nisha.projects.prompt2app.error.ResourceNotFoundException;
import com.nisha.projects.prompt2app.mapper.ProjectMapper;
import com.nisha.projects.prompt2app.repository.ProjectMemberRepository;
import com.nisha.projects.prompt2app.repository.ProjectRepository;
import com.nisha.projects.prompt2app.repository.UserRepository;
import com.nisha.projects.prompt2app.service.ProjectService;
import jakarta.transaction.Transactional;
import java.time.Instant;
import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Transactional
public class ProjectServiceImpl implements ProjectService {

  ProjectRepository projectRepository;
  UserRepository userRepository;
  ProjectMemberRepository projectMemberRepository;
  ProjectMapper projectMapper;

  @Override
  public ProjectResponse createProject(ProjectRequest request, Long userId) {
    User owner =
        userRepository
            .findById(userId)
            .orElseThrow(() -> new ResourceNotFoundException("User", userId.toString()));
    Project project = Project.builder().name(request.name()).isPublic(false).build();
    project = projectRepository.save(project);
    ProjectMemberId projectMemberId = new ProjectMemberId(project.getId(), owner.getId());
    ProjectMember projectMember =
        ProjectMember.builder()
            .id(projectMemberId)
            .projectRole(ProjectRole.OWNER)
            .user(owner)
            .acceptedAt(Instant.now())
            .invitedAt(Instant.now())
            .project(project)
            .build();
    projectMemberRepository.save(projectMember);

    return projectMapper.toProjectResponse(project);
  }

  @Override
  public List<ProjectSummaryResponse> getUserProjects(Long userId) {
    var projects = projectRepository.findAllAccessibleByUser(userId);
    return projectMapper.toProjectSummaryResponse(projects);
  }

  @Override
  public ProjectResponse getUserProjectById(Long id, Long userId) {
    Project project = getAccessibleProjectById(id, userId);
    return projectMapper.toProjectResponse(project);
  }

  @Override
  public ProjectResponse updateProject(Long id, ProjectRequest request, Long userId) {

    Project project = getAccessibleProjectById(id, userId);
    project.setName(request.name());
    project = projectRepository.save(project);
    return projectMapper.toProjectResponse(project);
  }

  @Override
  public void softDelete(Long id, Long userId) {
    Project project = getAccessibleProjectById(id, userId);

    project.setDeletedAt(Instant.now());
    projectRepository.save(project);
  }

  public Project getAccessibleProjectById(Long projectId, Long userId) {
    return projectRepository
        .findAccessibleByProjectId(projectId, userId)
        .orElseThrow(() -> new ResourceNotFoundException("Project", projectId.toString()));
  }
}
