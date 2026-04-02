package com.nisha.projects.prompt2app.enums;

import static com.nisha.projects.prompt2app.enums.ProjectPermission.*;

import java.util.Set;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum ProjectRole {
  EDITOR(VIEW, EDIT, DELETE, VIEW_MEMBERS),
  VIEWER(Set.of(VIEW, VIEW_MEMBERS)),
  OWNER(Set.of(VIEW, EDIT, DELETE, MANAGE_MEMBERS, VIEW_MEMBERS));

  ProjectRole(ProjectPermission... permissions) {
    this.permissions = Set.of(permissions);
  }

  private final Set<ProjectPermission> permissions;
}
