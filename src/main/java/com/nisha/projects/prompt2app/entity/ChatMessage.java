package com.nisha.projects.prompt2app.entity;

import com.nisha.projects.prompt2app.enums.MessageRole;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.Instant;
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ChatMessage {
    Long id;
    ChatSession chatSession;
    String content;
    String toolCalls;
    Integer tokensUsed;
    Instant createdAt;
    MessageRole role;

}
