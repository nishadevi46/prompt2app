package com.nisha.projects.prompt2app.repository;

import com.nisha.projects.prompt2app.entity.Project;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
  @Query(
      """
            SELECT p from Project p
            WHERE p.deletedAt is NULL
            ORDER BY p.updatedAt DESC
            """)
  List<Project> findAllAccessibleByUser(@Param("userId") Long userId);

  @Query(
      """
            SELECT p from Project p
            WHERE p.id=:projectId
            AND p.deletedAt is NULL
            """)
  Optional<Project> findAccessibleByProjectId(
      @Param("projectId") Long projectId, @Param("userId") Long userId);
}
