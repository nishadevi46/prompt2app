package com.nisha.projects.prompt2app.service;

import com.nisha.projects.prompt2app.dto.member.InviteMemberRequest;
import com.nisha.projects.prompt2app.dto.member.MemberResponse;
import com.nisha.projects.prompt2app.dto.member.UpdateMemberRoleRequest;
import java.util.List;

public interface ProjectMemberService {
  List<MemberResponse> getProjectMembers(Long projectId);

  MemberResponse inviteMember(Long projectId, InviteMemberRequest request);

  MemberResponse updateMemberRole(Long projectId, Long memberId, UpdateMemberRoleRequest request);

  void removeProjectMember(Long projectId, Long memberId);
}
