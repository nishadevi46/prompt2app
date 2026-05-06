package com.nisha.projects.prompt2app.mapper;

import com.nisha.projects.prompt2app.dto.chat.ChatResponse;
import com.nisha.projects.prompt2app.entity.ChatMessage;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ChatMapper {

    List<ChatResponse> fromListOfChatMessage(List<ChatMessage> chatMessageList);
}