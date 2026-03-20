package com.nisha.projects.prompt2app.service.impl;

import com.nisha.projects.prompt2app.dto.project.FileContentResponse;
import com.nisha.projects.prompt2app.dto.project.FileNode;
import com.nisha.projects.prompt2app.service.FileService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class FileServiceImpl implements FileService {
  @Override
  public FileContentResponse getFileContent(Long projectId, String path, Long userId) {
    return null;
  }

  @Override
  public List<FileNode> getFileTree(Long projectId, Long userId) {
    return List.of();
  }
}
