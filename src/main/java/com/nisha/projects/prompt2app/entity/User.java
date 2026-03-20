package com.nisha.projects.prompt2app.entity;

import jakarta.persistence.*;
import java.time.Instant;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "users")
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;

  String email;
  String passwordHash;
  String name;

  String avatarUrl;
  @CreationTimestamp Instant createdAt;
  @UpdateTimestamp Instant updatedAt;
  Instant deletedAt;
}
