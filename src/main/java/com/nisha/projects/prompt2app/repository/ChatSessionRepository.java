package com.nisha.projects.prompt2app.repository;

import com.nisha.projects.prompt2app.entity.ChatSession;
import com.nisha.projects.prompt2app.entity.ChatSessionId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatSessionRepository extends JpaRepository<ChatSession, ChatSessionId> {
}

