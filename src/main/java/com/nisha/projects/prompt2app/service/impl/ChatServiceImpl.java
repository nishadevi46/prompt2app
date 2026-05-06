package com.nisha.projects.prompt2app.service.impl;

import com.nisha.projects.prompt2app.dto.chat.ChatResponse;
import com.nisha.projects.prompt2app.entity.ChatMessage;
import com.nisha.projects.prompt2app.entity.ChatSession;
import com.nisha.projects.prompt2app.entity.ChatSessionId;
import com.nisha.projects.prompt2app.mapper.ChatMapper;
import com.nisha.projects.prompt2app.repository.ChatMessageRepository;
import com.nisha.projects.prompt2app.repository.ChatSessionRepository;
import com.nisha.projects.prompt2app.security.AuthUtil;
import com.nisha.projects.prompt2app.service.ChatService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ChatServiceImpl implements ChatService {

    private final ChatMessageRepository chatMessageRepository;
    private final ChatSessionRepository chatSessionRepository;
    private final AuthUtil authUtil;
    private final ChatMapper chatMapper;

    @Override
    public List<ChatResponse> getProjectChatHistory(Long projectId) {
        Long userId = authUtil.getCurrentUserId();

        ChatSession chatSession = chatSessionRepository.getReferenceById(
                new ChatSessionId(projectId, userId)
        );

        List<ChatMessage> chatMessageList = chatMessageRepository.findByChatSession(chatSession);

        return chatMapper.fromListOfChatMessage(chatMessageList);
    }
}