package com.nisha.projects.prompt2app.dto.project;

import com.nisha.projects.prompt2app.enums.ProjectRole;

import java.time.Instant;

public record ProjectSummaryResponse(
        Long id,
        String name,
        Instant createdAt,
        Instant updatedAt,
        ProjectRole role
) {
}
