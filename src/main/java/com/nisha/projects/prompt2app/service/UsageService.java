package com.nisha.projects.prompt2app.service;

import com.nisha.projects.prompt2app.dto.subscription.PlanLimitsResponse;
import com.nisha.projects.prompt2app.dto.subscription.UsageTodayResponse;

public interface UsageService {
    void recordTokenUsage(Long userId, int actualTokens);
    void checkDailyTokensUsage();
}
