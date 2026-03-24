package com.nisha.projects.prompt2app.entity;

import com.nisha.projects.prompt2app.enums.ProjectRole;
import jakarta.persistence.*;
import java.time.Instant;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "project_members")
public class ProjectMember {
  @EmbeddedId ProjectMemberId id;

  @ManyToOne
  @MapsId("projectId")
  Project project;

  @ManyToOne
  @MapsId("userId")
  User user;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  ProjectRole projectRole;

  Instant invitedAt;
  Instant acceptedAt;
}
