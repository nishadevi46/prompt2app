package com.nisha.projects.prompt2app.controller;

import com.nisha.projects.prompt2app.dto.project.FileContentResponse;
import com.nisha.projects.prompt2app.dto.project.FileNode;
import com.nisha.projects.prompt2app.dto.project.FileTreeResponse;
import com.nisha.projects.prompt2app.service.ProjectFileService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/projects/{projectId}/files")
@RequiredArgsConstructor
public class FileController {
  private final ProjectFileService projectFileService;

  @GetMapping
  public ResponseEntity<FileTreeResponse> getFileTree(@PathVariable Long projectId) {
    Long userId = 1L;
    return ResponseEntity.ok(projectFileService.getFileTree(projectId));
  }

    @GetMapping("/content")
    public ResponseEntity<FileContentResponse> getFile(
            @PathVariable Long projectId,
            @RequestParam String path) {
        return ResponseEntity.ok(projectFileService.getFileContent(projectId, path));
    }
}
