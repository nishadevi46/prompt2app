package com.nisha.projects.prompt2app.service;

import com.nisha.projects.prompt2app.dto.auth.AuthResponse;
import com.nisha.projects.prompt2app.dto.auth.LoginRequest;
import com.nisha.projects.prompt2app.dto.auth.SignUpRequest;

public interface AuthService {
  AuthResponse signup(SignUpRequest request);

  AuthResponse login(LoginRequest request);
}
