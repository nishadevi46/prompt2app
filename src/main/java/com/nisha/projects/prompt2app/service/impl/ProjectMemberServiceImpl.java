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
import com.nisha.projects.prompt2app.service.ProjectMemberService;
import jakarta.transaction.Transactional;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
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

  @Override
  public List<MemberResponse> getProjectMembers(Long projectId, Long userId) {
    Project project = getAccessibleProjectById(projectId, userId);
    List<MemberResponse> memberResponseList = new ArrayList<>();
    memberResponseList.add(projectMemberMapper.toMemberResponseFromOwner(project.getOwner()));
    memberResponseList.addAll(
        projectMemberRepository.findByProjectId(projectId).stream()
            .map(projectMemberMapper::toMemberResponseFromMember)
            .toList());
    return memberResponseList;
  }

  @Override
  public MemberResponse inviteMember(Long projectId, InviteMemberRequest request, Long userId) {
    Project project = getAccessibleProjectById(projectId, userId);
    if (!project.getOwner().getId().equals(userId)) {
      throw new RuntimeException("Not allowed");
    }
    User invitee = userRepository.findByEmail(request.email()).orElseThrow();
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
  public MemberResponse updateMemberRole(
      Long projectId, Long memberId, UpdateMemberRoleRequest request, Long userId) {
    Project project = getAccessibleProjectById(projectId, userId);
    if (!project.getOwner().getId().equals(userId)) {
      throw new RuntimeException("Not allowed");
    }
    ProjectMemberId projectMemberId = new ProjectMemberId(projectId, memberId);
    ProjectMember projectMember = projectMemberRepository.findById(projectMemberId).orElseThrow();
    projectMember.setProjectRole(request.role());
    projectMemberRepository.save(projectMember);
    return projectMemberMapper.toMemberResponseFromMember(projectMember);
  }

  @Override
  public void removeProjectMember(Long projectId, Long memberId, Long userId) {
    Project project = getAccessibleProjectById(projectId, userId);
    if (!project.getOwner().getId().equals(userId)) {
      throw new RuntimeException("Not allowed");
    }
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
