package com.nisha.projects.prompt2app.service.impl;

import com.nisha.projects.prompt2app.dto.auth.UserProfileResponse;
import com.nisha.projects.prompt2app.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
  @Override
  public UserProfileResponse getProfile(Long userId) {
    return null;
  }
}
