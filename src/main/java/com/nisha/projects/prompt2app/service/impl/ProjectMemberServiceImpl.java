package com.nisha.projects.prompt2app.service.impl;

import com.nisha.projects.prompt2app.dto.member.InviteMemberRequest;
import com.nisha.projects.prompt2app.dto.member.MemberResponse;
import com.nisha.projects.prompt2app.dto.member.UpdateMemberRoleRequest;
import com.nisha.projects.prompt2app.entity.Project;
import com.nisha.projects.prompt2app.entity.ProjectMember;
import com.nisha.projects.prompt2app.entity.ProjectMemberId;
import com.nisha.projects.prompt2app.entity.User;
import com.nisha.projects.prompt2app.mapper.ProjectMemberMapper;
import com.nisha.projects.prompt2app.repository.ProjectMemberRepository;
import com.nisha.projects.prompt2app.repository.ProjectRepository;
import com.nisha.projects.prompt2app.repository.UserRepository;
import com.nisha.projects.prompt2app.security.AuthUtil;
import com.nisha.projects.prompt2app.service.ProjectMemberService;
import jakarta.transaction.Transactional;
import java.time.Instant;
import java.util.List;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
@Transactional
public class ProjectMemberServiceImpl implements ProjectMemberService {

  ProjectMemberRepository projectMemberRepository;
  ProjectRepository projectRepository;
  ProjectMemberMapper projectMemberMapper;
  UserRepository userRepository;
  AuthUtil authUtil;

  @Override
  @PreAuthorize("@security.canViewMembers(#projectId)")
  public List<MemberResponse> getProjectMembers(Long projectId) {
    Long userId = authUtil.getCurrentUserId();
    Project project = getAccessibleProjectById(projectId, userId);
    return projectMemberRepository.findByProjectId(projectId).stream()
        .map(projectMemberMapper::toMemberResponseFromMember)
        .toList();
  }

  @Override
  @PreAuthorize("@security.canManageMembers(#projectId)")
  public MemberResponse inviteMember(Long projectId, InviteMemberRequest request) {
    Long userId = authUtil.getCurrentUserId();
    Project project = getAccessibleProjectById(projectId, userId);

    User invitee = userRepository.findByUsername(request.username()).orElseThrow();
    if (invitee.getId().equals(userId)) {
      throw new RuntimeException("Cannot invite yourself");
    }
    ProjectMemberId projectMemberId = new ProjectMemberId(projectId, invitee.getId());
    if (projectMemberRepository.existsById(projectMemberId)) {
      throw new RuntimeException("Cannot invite once again");
    }
    ProjectMember member =
        ProjectMember.builder()
            .id(projectMemberId)
            .project(project)
            .user(invitee)
            .projectRole(request.role())
            .invitedAt(Instant.now())
            .build();
    projectMemberRepository.save(member);
    return projectMemberMapper.toMemberResponseFromMember(member);
  }

  @Override
  @PreAuthorize("@security.canManageMembers(#projectId)")
  public MemberResponse updateMemberRole(
      Long projectId, Long memberId, UpdateMemberRoleRequest request) {
    Long userId = authUtil.getCurrentUserId();
    Project project = getAccessibleProjectById(projectId, userId);

    ProjectMemberId projectMemberId = new ProjectMemberId(projectId, memberId);
    ProjectMember projectMember = projectMemberRepository.findById(projectMemberId).orElseThrow();
    projectMember.setProjectRole(request.role());
    projectMemberRepository.save(projectMember);
    return projectMemberMapper.toMemberResponseFromMember(projectMember);
  }

  @Override
  @PreAuthorize("@security.canManageMembers(#projectId)")
  public void removeProjectMember(Long projectId, Long memberId) {
    Long userId = authUtil.getCurrentUserId();
    Project project = getAccessibleProjectById(projectId, userId);

    ProjectMemberId projectMemberId = new ProjectMemberId(projectId, memberId);
    if (!projectMemberRepository.existsById(projectMemberId)) {
      throw new RuntimeException("member not found in project");
    }
    projectMemberRepository.deleteById(projectMemberId);
  }

  public Project getAccessibleProjectById(Long id, Long userId) {
    return projectRepository.findAccessibleByProjectId(id, userId).orElseThrow();
  }
}
