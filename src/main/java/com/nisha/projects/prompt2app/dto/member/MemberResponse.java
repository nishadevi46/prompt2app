package com.nisha.projects.prompt2app.dto.member;

import com.nisha.projects.prompt2app.enums.ProjectRole;
import java.time.Instant;

public record MemberResponse(
    Long userId, String username, String name, ProjectRole projectRole, Instant invitedAt) {}
