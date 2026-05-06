package com.nisha.projects.prompt2app.dto.chat;

import com.nisha.projects.prompt2app.enums.ChatEventType;

public record ChatEventResponse(
        Long id,
        ChatEventType type,
        Integer sequenceOrder,
        String content,
        String filePath,
        String metadata
) {
}
