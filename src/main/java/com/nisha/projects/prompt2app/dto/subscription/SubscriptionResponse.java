package com.nisha.projects.prompt2app.dto.subscription;

import java.time.Instant;

public record SubscriptionResponse(
    PlanResponse plan, String status, Instant currentPeriodEnd, Long tokenUsedThisCycle) {}
