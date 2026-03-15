package com.nisha.projects.prompt2app.service;

import com.nisha.projects.prompt2app.dto.project.FileContentResponse;
import com.nisha.projects.prompt2app.dto.project.FileNode;
import java.util.List;

public interface FileService {

  List<FileNode> getFileTree(Long projectId, Long userId);

  FileContentResponse getFileContent(Long projectId, String path, Long userId);
}
