package com.nisha.projects.prompt2app.mapper;

import com.nisha.projects.prompt2app.dto.project.ProjectResponse;
import com.nisha.projects.prompt2app.dto.project.ProjectSummaryResponse;
import com.nisha.projects.prompt2app.entity.Project;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProjectMapper {

  ProjectResponse toProjectResponse(Project project);

  @Mapping(target = "projectName", source = "name")
  ProjectSummaryResponse toProjectSummaryResponse(Project project);

  List<ProjectSummaryResponse> toProjectSummaryResponse(List<Project> projects);
}
