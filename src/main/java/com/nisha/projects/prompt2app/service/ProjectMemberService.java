package com.nisha.projects.prompt2app.service;

import com.nisha.projects.prompt2app.dto.member.InviteMemberRequest;
import com.nisha.projects.prompt2app.dto.member.MemberResponse;
import com.nisha.projects.prompt2app.dto.member.UpdateMemberRoleRequest;
import com.nisha.projects.prompt2app.entity.ProjectMember;
import java.util.List;

public interface ProjectMemberService {
  List<ProjectMember> getProjectMembers(Long projectId, Long userId);

  MemberResponse inviteMember(Long projectId, InviteMemberRequest request, Long userId);

  MemberResponse updateMemberRole(
      Long projectId, Long memberId, UpdateMemberRoleRequest request, Long userId);

  MemberResponse deleteProjectMember(Long projectId, Long memberId, Long userId);
}
