package com.nisha.projects.prompt2app.mapper;

import com.nisha.projects.prompt2app.dto.project.ProjectResponse;
import com.nisha.projects.prompt2app.dto.project.ProjectSummaryResponse;
import com.nisha.projects.prompt2app.entity.Project;
import java.util.List;

import com.nisha.projects.prompt2app.enums.ProjectRole;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProjectMapper {

    ProjectResponse toProjectResponse(Project project);

    ProjectSummaryResponse toProjectSummaryResponse(Project project, ProjectRole role);

    List<ProjectSummaryResponse> toListOfProjectSummaryResponse(List<Project> projects);
}
