package com.nisha.projects.prompt2app.service.impl;

import com.nisha.projects.prompt2app.dto.project.ProjectRequest;
import com.nisha.projects.prompt2app.dto.project.ProjectResponse;
import com.nisha.projects.prompt2app.dto.project.ProjectSummaryResponse;
import com.nisha.projects.prompt2app.entity.Project;
import com.nisha.projects.prompt2app.entity.User;
import com.nisha.projects.prompt2app.mapper.ProjectMapper;
import com.nisha.projects.prompt2app.repository.ProjectRepository;
import com.nisha.projects.prompt2app.repository.UserRepository;
import com.nisha.projects.prompt2app.service.ProjectService;
import java.util.List;
import java.util.stream.Collectors;

import jakarta.transaction.Transactional;
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
    ProjectMapper projectMapper;
    @Override
    public ProjectResponse createProject(ProjectRequest request, Long userId) {
        User owner =  userRepository.findById(userId).orElseThrow();
        Project project = Project.builder()
                .name(request.name())
                .owner(owner)
                .isPublic(false)
                .build();
        project=projectRepository.save(project);
        return projectMapper.toProjectResponse(project);
    }
  @Override
  public List<ProjectSummaryResponse> getUserProjects(Long userId) {
        var projects = projectRepository.findAllAccessibleByUser(userId);
       return projectMapper.toProjectSummaryResponse(projects);

  }

  @Override
  public ProjectResponse getUserProjectById(Long id, Long userId) {
    return null;
  }

  @Override
  public ProjectResponse updateProject(Long id, ProjectRequest request, Long userId) {
    return null;
  }

  @Override
  public void softDelete(Long id, Long userId) {}
}
