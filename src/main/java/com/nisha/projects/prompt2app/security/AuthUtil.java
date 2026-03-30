package com.nisha.projects.prompt2app.security;

import com.nisha.projects.prompt2app.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Date;
import javax.crypto.SecretKey;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class AuthUtil {

  @Value("${jwt.secret-key}")
  private String jwtSecretKey;

  private SecretKey getSecretKey() {
    return Keys.hmacShaKeyFor(jwtSecretKey.getBytes(StandardCharsets.UTF_8));
  }

  public String generateAccessToken(User user) {
    return Jwts.builder()
        .subject(user.getUsername())
        .claim("userId", user.getId().toString())
        .issuedAt(new Date())
        .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 10))
        .signWith(getSecretKey())
        .compact();
  }

  public JwtUserPrincipal verifyAccessToken(String token) {
    Claims claims =
        Jwts.parser().verifyWith(getSecretKey()).build().parseClaimsJws(token).getPayload();
    Long userId = Long.parseLong(claims.get("userId", String.class));
    String username = claims.get("username", String.class);
    return new JwtUserPrincipal(userId, username, new ArrayList<>());
  }

  public Long getCurrentUserId() {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    if (authentication == null
        || !(authentication.getPrincipal() instanceof JwtUserPrincipal userPrincipal)) {
      throw new AuthenticationCredentialsNotFoundException("No Jwt Found");
    }
    return userPrincipal.userId();
  }
}
