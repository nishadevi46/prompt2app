package com.nisha.projects.prompt2app.service.impl;

import com.nisha.projects.prompt2app.dto.member.InviteMemberRequest;
import com.nisha.projects.prompt2app.dto.member.MemberResponse;
import com.nisha.projects.prompt2app.dto.member.UpdateMemberRoleRequest;
import com.nisha.projects.prompt2app.entity.ProjectMember;
import com.nisha.projects.prompt2app.service.ProjectMemberService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ProjectMemberServiceImpl implements ProjectMemberService {
  @Override
  public MemberResponse deleteProjectMember(Long projectId, Long memberId, Long userId) {
    return null;
  }

  @Override
  public List<ProjectMember> getProjectMembers(Long projectId, Long userId) {
    return List.of();
  }

  @Override
  public MemberResponse inviteMember(Long projectId, InviteMemberRequest request, Long userId) {
    return null;
  }

  @Override
  public MemberResponse updateMemberRole(
      Long projectId, Long memberId, UpdateMemberRoleRequest request, Long userId) {
    return null;
  }
}
