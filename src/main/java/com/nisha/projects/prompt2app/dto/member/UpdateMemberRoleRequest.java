package com.nisha.projects.prompt2app.dto.member;

import com.nisha.projects.prompt2app.enums.ProjectRole;
import jakarta.validation.constraints.NotNull;

public record UpdateMemberRoleRequest(@NotNull ProjectRole role) {}
