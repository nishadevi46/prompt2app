package com.nisha.projects.prompt2app.dto.subscription;

public record PlanLimitsResponse(
    String planName, int maxTokensPerDay, int maxProjects, boolean unlimitedAi) {}
