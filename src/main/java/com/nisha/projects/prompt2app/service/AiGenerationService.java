package com.nisha.projects.prompt2app.service;

import com.nisha.projects.prompt2app.dto.chat.StreamResponse;
import reactor.core.publisher.Flux;

public interface AiGenerationService {
    Flux<StreamResponse> streamResponse(String message, Long projectId);
}
