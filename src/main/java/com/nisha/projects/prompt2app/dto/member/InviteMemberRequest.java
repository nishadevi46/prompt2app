package com.nisha.projects.prompt2app.dto.member;

import com.nisha.projects.prompt2app.enums.ProjectRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record InviteMemberRequest(@Email @NotBlank String username, @NotNull ProjectRole role) {}
