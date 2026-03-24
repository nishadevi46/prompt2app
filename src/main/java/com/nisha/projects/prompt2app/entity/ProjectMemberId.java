package com.nisha.projects.prompt2app.entity;

import jakarta.persistence.Embeddable;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class ProjectMemberId {
  Long projectId;
  Long userId;
}
