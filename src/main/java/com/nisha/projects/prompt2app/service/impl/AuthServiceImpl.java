package com.nisha.projects.prompt2app.service.impl;

import com.nisha.projects.prompt2app.dto.auth.AuthResponse;
import com.nisha.projects.prompt2app.dto.auth.LoginRequest;
import com.nisha.projects.prompt2app.dto.auth.SignUpRequest;
import com.nisha.projects.prompt2app.entity.User;
import com.nisha.projects.prompt2app.error.BadRequestException;
import com.nisha.projects.prompt2app.mapper.UserMapper;
import com.nisha.projects.prompt2app.repository.UserRepository;
import com.nisha.projects.prompt2app.service.AuthService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class AuthServiceImpl implements AuthService {
  UserRepository userRepository;
  UserMapper userMapper;
  PasswordEncoder passwordEncoder;

  @Override
  public AuthResponse signup(SignUpRequest request) {
    userRepository
        .findByUsername(request.username())
        .ifPresent(
            user -> {
              throw new BadRequestException(
                  "User already exists with username " + request.username());
            });
    User user = userMapper.toEntity(request);
    user.setPassword(passwordEncoder.encode(user.getPassword()));
    user = userRepository.save(user);
    return new AuthResponse("dummy", userMapper.toUserProfileResponse(user));
  }

  @Override
  public AuthResponse login(LoginRequest request) {
    return null;
  }
}
