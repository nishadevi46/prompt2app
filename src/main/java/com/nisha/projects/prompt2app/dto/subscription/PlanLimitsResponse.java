package com.nisha.projects.prompt2app.dto.subscription;

public record PlanLimitsResponse(
    String planName, Integer maxTokensPerDay, Integer maxProjects, Boolean unlimitedAi) {}
