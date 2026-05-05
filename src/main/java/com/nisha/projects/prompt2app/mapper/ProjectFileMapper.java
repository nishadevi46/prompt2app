package com.nisha.projects.prompt2app.mapper;

import com.nisha.projects.prompt2app.dto.project.FileNode;
import com.nisha.projects.prompt2app.entity.ProjectFile;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProjectFileMapper {

    List<FileNode> toListOfFileNode(List<ProjectFile> projectFileList);
}