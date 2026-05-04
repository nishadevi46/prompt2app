package com.nisha.projects.prompt2app.dto.chat;

import com.nisha.projects.prompt2app.enums.MessageRole;

import java.time.Instant;

public record ChatRequest(String message, Long projectId) {}
