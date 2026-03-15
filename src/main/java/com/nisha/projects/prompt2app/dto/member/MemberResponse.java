package com.nisha.projects.prompt2app.dto.member;

import com.nisha.projects.prompt2app.enums.ProjectRole;
import java.time.Instant;

public record MemberResponse(
    Long userId,
    String email,
    String name,
    String avatarUrl,
    ProjectRole role,
    Instant invitedAt) {}
