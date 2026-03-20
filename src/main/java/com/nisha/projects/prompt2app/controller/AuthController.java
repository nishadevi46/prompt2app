package com.nisha.projects.prompt2app.controller;

import com.nisha.projects.prompt2app.dto.auth.AuthResponse;
import com.nisha.projects.prompt2app.dto.auth.LoginRequest;
import com.nisha.projects.prompt2app.dto.auth.SignUpRequest;
import com.nisha.projects.prompt2app.dto.auth.UserProfileResponse;
import com.nisha.projects.prompt2app.service.AuthService;
import com.nisha.projects.prompt2app.service.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class AuthController {
  AuthService authService;
  UserService userService;

  @PostMapping("/signup")
  public ResponseEntity<AuthResponse> signUp(@RequestBody SignUpRequest request) {
    return ResponseEntity.ok(authService.signup(request));
  }

  @PostMapping("/login")
  public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {
    return ResponseEntity.ok(authService.login(request));
  }

  @GetMapping("/me")
  public ResponseEntity<UserProfileResponse> getProfile() {
    Long userId = 1L;
    return ResponseEntity.ok(userService.getProfile(userId));
  }
}
