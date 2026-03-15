package com.nisha.projects.prompt2app.dto.subscription;

public record PlanResponse(
    Long id,
    String name,
    String stripePriceId,
    Integer maxProjects,
    Integer maxTokensPerDay,
    Boolean unlimitedAi,
    Boolean active) {}
