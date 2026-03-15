package com.nisha.projects.prompt2app.dto.subscription;

public record UsageTodayResponse(
    int tokensUsed, int tokensLimit, int previewsRunning, int previewsLimit) {}
