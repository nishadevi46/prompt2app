package com.nisha.projects.prompt2app.service;

import com.nisha.projects.prompt2app.dto.project.FileContentResponse;
import com.nisha.projects.prompt2app.dto.project.FileNode;
import com.nisha.projects.prompt2app.dto.project.FileTreeResponse;

import java.util.List;

public interface ProjectFileService {

    FileTreeResponse getFileTree(Long projectId);

    FileContentResponse getFileContent(Long projectId, String path);

    void saveFile(Long projectId, String filePath, String fileContent);
}
