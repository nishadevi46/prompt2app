package com.nisha.projects.prompt2app.service.impl;

import com.nisha.projects.prompt2app.service.AiGenerationService;
import org.springframework.stereotype.Service;

@Service
public class AiGenerationServiceImpl implements AiGenerationService {
    @Override
    public Flux<StreamResponse> streamResponse(String message, Long projectId) {
        return null;
    }
}
