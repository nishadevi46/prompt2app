package com.nisha.projects.prompt2app.dto.project;

import com.nisha.projects.prompt2app.dto.auth.UserProfileResponse;
import java.time.Instant;

public record ProjectResponse(
    Long id, String name, Instant createdAt, Instant updatedAt, UserProfileResponse owner) {}
