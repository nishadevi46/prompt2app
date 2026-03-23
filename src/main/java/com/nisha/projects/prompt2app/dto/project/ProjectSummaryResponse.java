package com.nisha.projects.prompt2app.dto.project;

import java.time.Instant;

public record ProjectSummaryResponse(Long id, String projectName, Instant createdAt, Instant updatedAt) {}
