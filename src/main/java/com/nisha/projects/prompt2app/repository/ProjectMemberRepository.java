package com.nisha.projects.prompt2app.repository;

import com.nisha.projects.prompt2app.entity.ProjectMember;
import com.nisha.projects.prompt2app.entity.ProjectMemberId;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectMemberRepository extends JpaRepository<ProjectMember, ProjectMemberId> {
  List<ProjectMember> findByProjectId(Long projectId);
}
