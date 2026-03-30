package com.nisha.projects.prompt2app.security;

import java.util.List;
import org.springframework.security.core.GrantedAuthority;

public record JwtUserPrincipal(Long userId, String username, List<GrantedAuthority> authorities) {}
