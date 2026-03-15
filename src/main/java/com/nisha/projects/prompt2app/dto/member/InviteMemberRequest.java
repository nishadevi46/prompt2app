package com.nisha.projects.prompt2app.dto.member;

import com.nisha.projects.prompt2app.enums.ProjectRole;

public record InviteMemberRequest(String email, ProjectRole role) {}
