package com.nisha.projects.prompt2app.service;

import com.nisha.projects.prompt2app.dto.chat.ChatResponse;

import java.util.List;

public interface ChatService {

    List<ChatResponse> getProjectChatHistory(Long projectId);
}
