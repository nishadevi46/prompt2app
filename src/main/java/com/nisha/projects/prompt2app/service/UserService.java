package com.nisha.projects.prompt2app.service;

import com.nisha.projects.prompt2app.dto.auth.UserProfileResponse;

public interface UserService {

  UserProfileResponse getProfile(Long userId);
}
