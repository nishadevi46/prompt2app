package com.nisha.projects.prompt2app.service;

public interface AiGenerationService {
    Flux<StreamResponse> streamResponse(String message, Long projectId);
}
