package com.nisha.projects.prompt2app.dto.subscription;

public record UsageTodayResponse(
    Integer tokensUsed, Integer tokensLimit, Integer previewsRunning, Integer previewsLimit) {}
