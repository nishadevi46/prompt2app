package com.nisha.projects.prompt2app.mapper;

import com.nisha.projects.prompt2app.dto.auth.SignUpRequest;
import com.nisha.projects.prompt2app.dto.auth.UserProfileResponse;
import com.nisha.projects.prompt2app.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
  User toEntity(SignUpRequest signUpRequest);

  UserProfileResponse toUserProfileResponse(User user);
}
