package com.nisha.projects.prompt2app.service.impl;

import com.nisha.projects.prompt2app.dto.auth.UserProfileResponse;
import com.nisha.projects.prompt2app.error.ResourceNotFoundException;
import com.nisha.projects.prompt2app.repository.UserRepository;
import com.nisha.projects.prompt2app.service.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService, UserDetailsService {
  UserRepository userRepository;

  @Override
  public UserProfileResponse getProfile(Long userId) {
    return null;
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    return userRepository
        .findByUsername(username)
        .orElseThrow(() -> new ResourceNotFoundException("User", username));
  }
}
