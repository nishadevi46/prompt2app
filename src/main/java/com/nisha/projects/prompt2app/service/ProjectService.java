package com.nisha.projects.prompt2app.service;

import com.nisha.projects.prompt2app.dto.project.ProjectRequest;
import com.nisha.projects.prompt2app.dto.project.ProjectResponse;
import com.nisha.projects.prompt2app.dto.project.ProjectSummaryResponse;
import java.util.List;

public interface ProjectService {
  List<ProjectSummaryResponse> getUserProjects(Long userId);

  ProjectResponse getUserProjectById(Long id, Long userId);

  ProjectResponse createProject(ProjectRequest request, Long userId);

  ProjectResponse updateProject(Long id, ProjectRequest request, Long userId);

  void softDelete(Long id, Long userId);
}
