package com.nisha.projects.prompt2app.service.impl;

import com.nisha.projects.prompt2app.dto.auth.AuthResponse;
import com.nisha.projects.prompt2app.dto.auth.LoginRequest;
import com.nisha.projects.prompt2app.dto.auth.SignUpRequest;
import com.nisha.projects.prompt2app.service.AuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
  @Override
  public AuthResponse signup(SignUpRequest request) {
    return null;
  }

  @Override
  public AuthResponse login(LoginRequest request) {
    return null;
  }
}
