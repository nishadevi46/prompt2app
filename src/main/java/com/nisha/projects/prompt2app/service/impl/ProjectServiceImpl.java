package com.nisha.projects.prompt2app.service.impl;

import com.nisha.projects.prompt2app.dto.project.ProjectRequest;
import com.nisha.projects.prompt2app.dto.project.ProjectResponse;
import com.nisha.projects.prompt2app.dto.project.ProjectSummaryResponse;
import com.nisha.projects.prompt2app.service.ProjectService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ProjectServiceImpl implements ProjectService {
  @Override
  public List<ProjectSummaryResponse> getUserProjects(Long userId) {
    return List.of();
  }

  @Override
  public ProjectResponse getUserProjectById(Long id, Long userId) {
    return null;
  }

  @Override
  public ProjectResponse createProject(ProjectRequest request, Long userId) {
    return null;
  }

  @Override
  public ProjectResponse updateProject(Long id, ProjectRequest request, Long userId) {
    return null;
  }

  @Override
  public void softDelete(Long id, Long userId) {}
}
